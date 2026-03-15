package fr.isen.vojtechsanda.disneydex.domain.usecase.auth

import fr.isen.vojtechsanda.disneydex.domain.model.User
import fr.isen.vojtechsanda.disneydex.domain.repository.UserRepository

class GetCurrentUserUseCase(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(): User? = userRepository.getCurrentUser()
}
