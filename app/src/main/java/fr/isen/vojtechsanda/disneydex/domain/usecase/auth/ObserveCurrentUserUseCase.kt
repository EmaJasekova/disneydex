package fr.isen.vojtechsanda.disneydex.domain.usecase.auth

import fr.isen.vojtechsanda.disneydex.domain.model.User
import fr.isen.vojtechsanda.disneydex.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class ObserveCurrentUserUseCase(private val userRepository: UserRepository) {
    operator fun invoke(): Flow<Result<User?>> =
        userRepository.observeCurrentUser()
}
