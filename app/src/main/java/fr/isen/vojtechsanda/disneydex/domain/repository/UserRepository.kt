package fr.isen.vojtechsanda.disneydex.domain.repository

import fr.isen.vojtechsanda.disneydex.domain.model.User

interface UserRepository {

    suspend fun getCurrentUser(): User?

    suspend fun saveUser(user: User)
}
