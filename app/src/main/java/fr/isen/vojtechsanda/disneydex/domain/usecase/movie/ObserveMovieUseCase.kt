package fr.isen.vojtechsanda.disneydex.domain.usecase.movie

import fr.isen.vojtechsanda.disneydex.domain.model.Movie
import fr.isen.vojtechsanda.disneydex.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class ObserveMovieUseCase(private val movieRepository: MovieRepository) {

    operator fun invoke(movieId: String): Flow<Movie?> =
        movieRepository.observeMovie(movieId)
}
