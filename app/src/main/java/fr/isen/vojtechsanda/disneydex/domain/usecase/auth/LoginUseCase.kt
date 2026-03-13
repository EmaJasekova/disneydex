package fr.isen.vojtechsanda.disneydex.domain.usecase.auth

import fr.isen.vojtechsanda.disneydex.domain.model.AuthUser
import fr.isen.vojtechsanda.disneydex.domain.repository.AuthRepository
import fr.isen.vojtechsanda.disneydex.domain.repository.UserRepository

class LoginUseCase(
    private val authRepository: AuthRepository,
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(email: String, password: String): Result<AuthUser> = runCatching {
        val credential = authRepository.login(email, password).getOrThrow()
        val username = userRepository.getUsername(credential.uid)
        AuthUser(credential = credential, username = username)
    }
}
