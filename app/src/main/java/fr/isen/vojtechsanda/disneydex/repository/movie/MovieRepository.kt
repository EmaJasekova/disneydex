package fr.isen.vojtechsanda.disneydex.repository.movie

import fr.isen.vojtechsanda.disneydex.domain.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    fun observeMoviesBySaga(sagaId: String): Flow<List<Movie>>

    fun observeMovie(movieId: String): Flow<Movie?>
}
