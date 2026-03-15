package fr.isen.vojtechsanda.disneydex.domain.usecase.auth

import fr.isen.vojtechsanda.disneydex.domain.model.User
import fr.isen.vojtechsanda.disneydex.domain.repository.AuthRepository
import fr.isen.vojtechsanda.disneydex.domain.repository.UserRepository

class RegisterUseCase(
    private val authRepository: AuthRepository,
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(email: String, password: String, username: String): Result<User> = runCatching {
        val authUser = authRepository.register(email, password).getOrThrow()
        userRepository.saveUsername(authUser.uid, username)
        // TODO: if saveUsername fails, delete the user credentials from the database and throw an exception
        User(uid = authUser.uid, email = authUser.email, username = username)
    }
}
