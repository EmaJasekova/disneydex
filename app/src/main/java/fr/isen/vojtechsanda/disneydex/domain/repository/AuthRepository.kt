package fr.isen.vojtechsanda.disneydex.domain.repository

import fr.isen.vojtechsanda.disneydex.domain.model.AuthUser

interface AuthRepository {

    suspend fun register(email: String, password: String): Result<AuthUser>

    suspend fun login(email: String, password: String): Result<AuthUser>

    suspend fun logout(): Result<Unit>

    suspend fun getCurrentUserCredentials(): AuthUser?
}
