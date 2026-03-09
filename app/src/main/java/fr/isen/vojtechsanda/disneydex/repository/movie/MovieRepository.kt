package fr.isen.vojtechsanda.disneydex.repository.movie

import fr.isen.vojtechsanda.disneydex.domain.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    fun getMoviesBySaga(sagaId: String): Flow<List<Movie>>

    fun getMovie(movieId: String): Flow<Movie?>
}
