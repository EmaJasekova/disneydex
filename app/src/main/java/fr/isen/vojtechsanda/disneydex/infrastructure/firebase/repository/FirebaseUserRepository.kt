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
        val userSnapshot = usersRef.child(firebaseUser.uid).get().await()
        val username = userSnapshot.child("username").getValue(String::class.java) ?: "Disney Fan"
        return User(
            uid = firebaseUser.uid,
            email = email,
            username = username
        )
    }

    override suspend fun saveUser(user: User): Result<Unit> = runCatching {
        val currentUser = auth.currentUser
            ?: throw InvalidAuthStateException("No authenticated user available to save profile data.")
        if (currentUser.uid != user.uid) {
            throw InvalidAuthStateException("Authenticated user does not match the profile being saved.")
        }
        usersRef.child(user.uid).child("username").setValue(user.username).await()
    }
}
