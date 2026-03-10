package fr.isen.vojtechsanda.disneydex

import fr.isen.vojtechsanda.disneydex.domain.repository.MovieRepository
import fr.isen.vojtechsanda.disneydex.domain.repository.SagaRepository
import fr.isen.vojtechsanda.disneydex.domain.repository.UniverseRepository
import fr.isen.vojtechsanda.disneydex.domain.service.AuthService
import fr.isen.vojtechsanda.disneydex.infrastructure.firebase.auth.FirebaseAuthService
import fr.isen.vojtechsanda.disneydex.infrastructure.firebase.repository.FirebaseMovieRepository
import fr.isen.vojtechsanda.disneydex.infrastructure.firebase.repository.FirebaseSagaRepository
import fr.isen.vojtechsanda.disneydex.infrastructure.firebase.repository.FirebaseUniverseRepository

object AppContainer {
    
    val authService: AuthService by lazy {
        FirebaseAuthService()
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
