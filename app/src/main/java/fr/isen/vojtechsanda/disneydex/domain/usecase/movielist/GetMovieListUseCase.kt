package fr.isen.vojtechsanda.disneydex.domain.usecase.movielist

import fr.isen.vojtechsanda.disneydex.domain.model.MovieListType
import fr.isen.vojtechsanda.disneydex.domain.repository.UserRepository

class GetMovieListUseCase(private val userRepository: UserRepository) {
    suspend operator fun invoke(list: MovieListType): Result<List<String>> =
        userRepository.getMovieList(list)
}
