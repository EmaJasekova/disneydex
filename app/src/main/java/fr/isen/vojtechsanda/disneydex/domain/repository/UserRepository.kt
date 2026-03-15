package fr.isen.vojtechsanda.disneydex.domain.repository

import fr.isen.vojtechsanda.disneydex.domain.model.User

interface UserRepository {

    suspend fun getCurrentUser(): User?

    suspend fun getUsername(uid: String): String

    suspend fun saveUsername(uid: String, username: String)
}
