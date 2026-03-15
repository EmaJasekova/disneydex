package fr.isen.vojtechsanda.disneydex.domain.usecase.movielist

import fr.isen.vojtechsanda.disneydex.domain.model.MovieListType
import fr.isen.vojtechsanda.disneydex.domain.repository.UserRepository

class RemoveMovieFromListUseCase(private val userRepository: UserRepository) {
    suspend operator fun invoke(movieId: String, list: MovieListType): Result<Unit> = runCatching {
        userRepository.removeMovieFromList(movieId, list).getOrThrow()

        // if you do not own the movie, you cannot trade it (remove from for trade list)
        if (list == MovieListType.OWNED) {
            userRepository.removeMovieFromList(movieId, MovieListType.FOR_TRADE).getOrThrow()
        }
    }
}
