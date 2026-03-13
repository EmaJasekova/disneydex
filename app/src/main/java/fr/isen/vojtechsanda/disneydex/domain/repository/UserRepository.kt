package fr.isen.vojtechsanda.disneydex.domain.repository

interface UserRepository {

    suspend fun getUsername(uid: String): String
    
    suspend fun saveUsername(uid: String, username: String)
}
