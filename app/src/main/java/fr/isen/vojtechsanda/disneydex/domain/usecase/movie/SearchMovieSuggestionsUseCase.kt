package fr.isen.vojtechsanda.disneydex.domain.usecase.movie

import fr.isen.vojtechsanda.disneydex.domain.model.Movie
import fr.isen.vojtechsanda.disneydex.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow

class SearchMovieSuggestionsUseCase(private val movieRepository: MovieRepository) {
    operator fun invoke(query: String): Flow<List<Movie>> =
        movieRepository.searchMovieSuggestions(query)
}
