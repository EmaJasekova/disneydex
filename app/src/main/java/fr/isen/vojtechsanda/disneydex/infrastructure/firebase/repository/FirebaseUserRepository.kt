package fr.isen.vojtechsanda.disneydex.infrastructure.firebase.repository

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import fr.isen.vojtechsanda.disneydex.domain.exception.InvalidAuthStateException
import fr.isen.vojtechsanda.disneydex.domain.model.User
import fr.isen.vojtechsanda.disneydex.domain.repository.UserRepository
import kotlinx.coroutines.tasks.await

class FirebaseUserRepository : UserRepository {

    private val auth = FirebaseAuth.getInstance()
    private val usersRef = FirebaseDatabase.getInstance().getReference("users")

    override suspend fun getCurrentUser(): User? {
        val firebaseUser = auth.currentUser ?: return null
        val email = firebaseUser.email
            ?: throw InvalidAuthStateException("Email is required but was not provided by the authentication provider.")
        // todo fetch the whole node at once when we add more fields
            val username = getUsername(firebaseUser.uid)
        return User(uid = firebaseUser.uid, email = email, username = username)
    }

    override suspend fun getUsername(uid: String): String {
        val usernameSnapshot = usersRef.child(uid).child("username").get().await()
        return usernameSnapshot.getValue(String::class.java) ?: "Disney Fan"
    }

    override suspend fun saveUsername(uid: String, username: String) {
        usersRef.child(uid).child("username").setValue(username).await()
    }
}
