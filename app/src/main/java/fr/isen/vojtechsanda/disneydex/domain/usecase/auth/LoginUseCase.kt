package fr.isen.vojtechsanda.disneydex.domain.usecase.auth

import fr.isen.vojtechsanda.disneydex.domain.exception.UserProfileMissingException
import fr.isen.vojtechsanda.disneydex.domain.model.User
import fr.isen.vojtechsanda.disneydex.domain.repository.AuthRepository
import fr.isen.vojtechsanda.disneydex.domain.repository.UserRepository

class LoginUseCase(
    private val authRepository: AuthRepository,
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(email: String, password: String): Result<User> = runCatching {
        val authUser = authRepository.login(email, password).getOrThrow()
        userRepository.getUser(authUser.uid).getOrThrow()
            ?: throw UserProfileMissingException()
    }
}
