package fr.isen.vojtechsanda.disneydex.domain.repository

import fr.isen.vojtechsanda.disneydex.domain.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    fun observeMoviesBySaga(sagaId: String): Flow<List<Movie>>

    fun observeMovie(movieId: String): Flow<Movie?>

    fun observeMovieTraders(movieId: String): Flow<List<String>>
}
