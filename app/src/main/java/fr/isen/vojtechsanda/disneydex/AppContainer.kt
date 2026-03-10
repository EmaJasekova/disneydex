package fr.isen.vojtechsanda.disneydex

import fr.isen.vojtechsanda.disneydex.domain.repository.MovieRepository
import fr.isen.vojtechsanda.disneydex.domain.repository.SagaRepository
import fr.isen.vojtechsanda.disneydex.domain.repository.UniverseRepository
import fr.isen.vojtechsanda.disneydex.infrastructure.firebase.FirebaseMovieRepository
import fr.isen.vojtechsanda.disneydex.infrastructure.firebase.FirebaseSagaRepository
import fr.isen.vojtechsanda.disneydex.infrastructure.firebase.FirebaseUniverseRepository

object AppContainer {
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
