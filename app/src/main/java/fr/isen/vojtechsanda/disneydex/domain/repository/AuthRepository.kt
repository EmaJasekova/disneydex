package fr.isen.vojtechsanda.disneydex.domain.repository

import fr.isen.vojtechsanda.disneydex.domain.model.AuthCredential

interface AuthRepository {

    suspend fun register(email: String, password: String): Result<AuthCredential>

    suspend fun login(email: String, password: String): Result<AuthCredential>

    suspend fun logout(): Result<Unit>

    suspend fun getCurrentUser(): AuthCredential?
}
