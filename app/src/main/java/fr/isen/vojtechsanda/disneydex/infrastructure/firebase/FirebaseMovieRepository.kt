package fr.isen.vojtechsanda.disneydex.infrastructure.firebase

import fr.isen.vojtechsanda.disneydex.domain.model.Movie
import fr.isen.vojtechsanda.disneydex.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

object FirebaseMovieRepository : MovieRepository {

    override fun observeMoviesBySaga(sagaId: String): Flow<List<Movie>> =
        FirebaseSagaRepository.observeSaga(sagaId).map { saga ->
            saga?.movies ?: emptyList()
        }

    override fun observeMovie(movieId: String): Flow<Movie?> =
        FirebaseSagaRepository.observeAllSagas().map { sagas ->
            sagas
                .flatMap { saga -> saga.movies }
                .find { movie -> movie.id == movieId }
        }
}
