package fr.isen.vojtechsanda.disneydex.domain.usecase.movie

import fr.isen.vojtechsanda.disneydex.domain.model.Movie
import fr.isen.vojtechsanda.disneydex.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class ObserveMoviesUseCase(private val movieRepository: MovieRepository) {
    operator fun invoke(movieIds: List<String>): Flow<List<Movie?>> =
        movieRepository.observeMovies(movieIds)
}
