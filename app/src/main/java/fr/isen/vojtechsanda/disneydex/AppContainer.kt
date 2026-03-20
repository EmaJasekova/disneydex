package fr.isen.vojtechsanda.disneydex

import fr.isen.vojtechsanda.disneydex.domain.repository.MovieRepository
import fr.isen.vojtechsanda.disneydex.domain.repository.SagaRepository
import fr.isen.vojtechsanda.disneydex.domain.repository.UniverseRepository
import fr.isen.vojtechsanda.disneydex.domain.usecase.auth.GetCurrentUserUseCase
import fr.isen.vojtechsanda.disneydex.domain.usecase.auth.LoginUseCase
import fr.isen.vojtechsanda.disneydex.domain.usecase.auth.LogoutUseCase
import fr.isen.vojtechsanda.disneydex.domain.usecase.auth.RegisterUseCase
import fr.isen.vojtechsanda.disneydex.domain.usecase.movie.ObserveMovieTradersUseCase
import fr.isen.vojtechsanda.disneydex.domain.usecase.movie.SearchMovieSuggestionsUseCase
import fr.isen.vojtechsanda.disneydex.domain.usecase.movielist.AddMovieToListUseCase
import fr.isen.vojtechsanda.disneydex.domain.usecase.movielist.ObserveMovieListUseCase
import fr.isen.vojtechsanda.disneydex.domain.usecase.movielist.RemoveMovieFromListUseCase
import fr.isen.vojtechsanda.disneydex.domain.usecase.universe.ObserveUniverseUseCase
import fr.isen.vojtechsanda.disneydex.domain.usecase.universe.ObserveUniversesUseCase
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

    val addMovieToListUseCase by lazy {
        AddMovieToListUseCase(userRepository)
    }

    val removeMovieFromListUseCase by lazy {
        RemoveMovieFromListUseCase(userRepository)
    }

    val observeMovieListUseCase by lazy {
        ObserveMovieListUseCase(userRepository)
    }

    private val universeRepository: UniverseRepository by lazy {
        FirebaseUniverseRepository()
    }

    val observeUniversesUseCase: ObserveUniversesUseCase by lazy {
        ObserveUniversesUseCase(universeRepository)
    }

    val observeUniverseUseCase: ObserveUniverseUseCase by lazy {
        ObserveUniverseUseCase(universeRepository)
    }

    private val sagaRepository: SagaRepository by lazy {
        FirebaseSagaRepository(universeRepository)
    }

    private val movieRepository: MovieRepository by lazy {
        FirebaseMovieRepository(sagaRepository)
    }

    val observeMovieTradersUseCase: ObserveMovieTradersUseCase by lazy {
        ObserveMovieTradersUseCase(movieRepository, userRepository)
    }

    val searchMovieSuggestionsUseCase: SearchMovieSuggestionsUseCase by lazy {
        SearchMovieSuggestionsUseCase(movieRepository)
    }
}
