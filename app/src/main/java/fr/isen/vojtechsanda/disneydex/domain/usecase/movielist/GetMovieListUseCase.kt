package fr.isen.vojtechsanda.disneydex.domain.usecase.movielist

import fr.isen.vojtechsanda.disneydex.domain.model.MovieListType
import fr.isen.vojtechsanda.disneydex.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class GetMovieListUseCase(private val userRepository: UserRepository) {
    operator fun invoke(list: MovieListType): Flow<List<String>> =
        userRepository.observeMovieList(list)
}
