package fr.isen.vojtechsanda.disneydex.infrastructure.firebase.repository

import com.google.firebase.database.FirebaseDatabase
import fr.isen.vojtechsanda.disneydex.domain.exception.InvalidUserDataException
import fr.isen.vojtechsanda.disneydex.domain.repository.UserRepository
import kotlinx.coroutines.tasks.await

class FirebaseUserRepository : UserRepository {

    private val usersRef = FirebaseDatabase.getInstance().getReference("users")

    override suspend fun getUsername(uid: String): String =
        usersRef.child(uid).child("username").get().await().getValue(String::class.java)
            ?: throw InvalidUserDataException("Username is required but was not found for user $uid.")

    override suspend fun saveUsername(uid: String, username: String) {
        usersRef.child(uid).child("username").setValue(username).await()
    }
}
