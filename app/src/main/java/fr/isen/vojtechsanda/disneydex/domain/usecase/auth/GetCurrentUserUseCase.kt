package fr.isen.vojtechsanda.disneydex.domain.usecase.auth

import fr.isen.vojtechsanda.disneydex.domain.model.AuthUser
import fr.isen.vojtechsanda.disneydex.domain.repository.AuthRepository
import fr.isen.vojtechsanda.disneydex.domain.repository.UserRepository

class GetCurrentUserUseCase(
    private val authRepository: AuthRepository,
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(): AuthUser? {
        val credential = authRepository.getCurrentUserCredentials() ?: return null
        val username = userRepository.getUsername(credential.uid)
        return AuthUser(credential = credential, username = username)
    }
}
