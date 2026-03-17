package fr.isen.vojtechsanda.disneydex.domain.usecase.movie

import fr.isen.vojtechsanda.disneydex.domain.model.User
import fr.isen.vojtechsanda.disneydex.domain.repository.MovieRepository
import fr.isen.vojtechsanda.disneydex.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapLatest

class ObserveMovieTradersUseCase(
    private val movieRepository: MovieRepository,
    private val userRepository: UserRepository
) {
    operator fun invoke(movieId: String): Flow<Result<List<User?>>> =
        movieRepository.observeMovieTraders(movieId)
            .flatMapLatest { uids -> userRepository.observeUsers(uids) }
}
