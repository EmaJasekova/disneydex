package fr.isen.vojtechsanda.disneydex.domain.usecase.auth

import fr.isen.vojtechsanda.disneydex.domain.model.AuthUser
import fr.isen.vojtechsanda.disneydex.domain.repository.AuthRepository
import fr.isen.vojtechsanda.disneydex.domain.repository.UserRepository

class RegisterUseCase(
    private val authRepository: AuthRepository,
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(email: String, password: String, username: String): Result<AuthUser> = runCatching {
        val credential = authRepository.register(email, password).getOrThrow()
        userRepository.saveUsername(credential.uid, username)
        AuthUser(credential = credential, username = username)
    }
}
