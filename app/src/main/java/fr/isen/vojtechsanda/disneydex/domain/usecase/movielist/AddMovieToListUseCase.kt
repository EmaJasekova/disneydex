package fr.isen.vojtechsanda.disneydex.domain.usecase.movielist

import fr.isen.vojtechsanda.disneydex.domain.exception.MovieListViolationException
import fr.isen.vojtechsanda.disneydex.domain.model.MovieListType
import fr.isen.vojtechsanda.disneydex.domain.repository.UserRepository

class AddMovieToListUseCase(private val userRepository: UserRepository) {
    suspend operator fun invoke(movieId: String, movieList: MovieListType): Result<Unit> = runCatching {
        
        // you have to own the movie to list it for trade
        if (movieList == MovieListType.FOR_TRADE && !userRepository.isMovieInList(movieId, MovieListType.OWNED).getOrThrow()) {
            throw MovieListViolationException("Movie must be in your owned list before it can be listed for trade.")
        }
        userRepository.addMovieToList(movieId, movieList).getOrThrow()
    }
}
