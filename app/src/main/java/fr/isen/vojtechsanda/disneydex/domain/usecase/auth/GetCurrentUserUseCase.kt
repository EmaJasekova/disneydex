package fr.isen.vojtechsanda.disneydex.domain.usecase.auth

import fr.isen.vojtechsanda.disneydex.domain.model.User
import fr.isen.vojtechsanda.disneydex.domain.repository.AuthRepository
import fr.isen.vojtechsanda.disneydex.domain.repository.UserRepository

class GetCurrentUserUseCase(
    private val authRepository: AuthRepository,
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(): User? {
        val uid = authRepository.getCurrentUserCredentials()?.uid ?: return null
        return userRepository.getUser(uid).getOrNull()
    }
}
