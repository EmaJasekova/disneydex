package fr.isen.vojtechsanda.disneydex.infrastructure.firebase

import fr.isen.vojtechsanda.disneydex.domain.model.Movie
import fr.isen.vojtechsanda.disneydex.domain.repository.MovieRepository
import fr.isen.vojtechsanda.disneydex.domain.repository.SagaRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class FirebaseMovieRepository(
    private val sagaRepository: SagaRepository
) : MovieRepository {

    override fun observeMoviesBySaga(sagaId: String): Flow<List<Movie>> =
        sagaRepository.observeSaga(sagaId).map { saga ->
            saga?.movies ?: emptyList()
        }

    override fun observeMovie(movieId: String): Flow<Movie?> =
        sagaRepository.observeAllSagas().map { sagas ->
            sagas.firstNotNullOfOrNull { saga ->
                saga.movies.find { movie -> movie.id == movieId }
            }
        }
}
