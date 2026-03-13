package fr.isen.vojtechsanda.disneydex

import fr.isen.vojtechsanda.disneydex.domain.repository.MovieRepository
import fr.isen.vojtechsanda.disneydex.domain.repository.SagaRepository
import fr.isen.vojtechsanda.disneydex.domain.repository.UniverseRepository
import fr.isen.vojtechsanda.disneydex.domain.usecase.auth.GetCurrentUserUseCase
import fr.isen.vojtechsanda.disneydex.domain.usecase.auth.LoginUseCase
import fr.isen.vojtechsanda.disneydex.domain.usecase.auth.LogoutUseCase
import fr.isen.vojtechsanda.disneydex.domain.usecase.auth.RegisterUseCase
import fr.isen.vojtechsanda.disneydex.infrastructure.firebase.repository.FirebaseAuthRepository
import fr.isen.vojtechsanda.disneydex.infrastructure.firebase.repository.FirebaseMovieRepository
import fr.isen.vojtechsanda.disneydex.infrastructure.firebase.repository.FirebaseSagaRepository
import fr.isen.vojtechsanda.disneydex.infrastructure.firebase.repository.FirebaseUniverseRepository
import fr.isen.vojtechsanda.disneydex.infrastructure.firebase.repository.FirebaseUserRepository

object AppContainer {

    private val authRepository by lazy {
        FirebaseAuthRepository()
    }

    private val userRepository by lazy {
        FirebaseUserRepository()
    }

    val loginUseCase by lazy {
        LoginUseCase(authRepository, userRepository)
    }

    val registerUseCase by lazy {
        RegisterUseCase(authRepository, userRepository)
    }

    val logoutUseCase by lazy {
        LogoutUseCase(authRepository)
    }

    val getCurrentUserUseCase by lazy {
        GetCurrentUserUseCase(authRepository, userRepository)
    }

    val universeRepository: UniverseRepository by lazy {
        FirebaseUniverseRepository()
    }

    val sagaRepository: SagaRepository by lazy {
        FirebaseSagaRepository(universeRepository)
    }

    val movieRepository: MovieRepository by lazy {
        FirebaseMovieRepository(sagaRepository)
    }
}
