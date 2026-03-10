package fr.isen.vojtechsanda.disneydex.domain.service

import fr.isen.vojtechsanda.disneydex.domain.model.AuthUser

interface AuthService {
    
    suspend fun register(email: String, password: String, username: String): Result<AuthUser>

    suspend fun login(email: String, password: String): Result<AuthUser>

    suspend fun logout(): Result<Unit>

    suspend fun getCurrentUser(): AuthUser?
}