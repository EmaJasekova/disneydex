package fr.isen.vojtechsanda.disneydex.infrastructure.firebase.auth

import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.DatabaseException
import com.google.firebase.database.FirebaseDatabase
import fr.isen.vojtechsanda.disneydex.domain.model.AuthContext
import fr.isen.vojtechsanda.disneydex.domain.model.AuthUser
import fr.isen.vojtechsanda.disneydex.domain.service.AuthService
import kotlinx.coroutines.tasks.await

class FirebaseAuthService : AuthService {

    private val auth = FirebaseAuth.getInstance()
    private val database = FirebaseDatabase.getInstance()
    private val usersRef = database.getReference("users")

    override suspend fun register(email: String, password: String, username: String): Result<AuthUser> {
        return runCatching {
            val firebaseUser = auth.createUserWithEmailAndPassword(email, password).await().user
                ?: throw Exception("Registration failed. Please try again.")
            usersRef.child(firebaseUser.uid).child("username").setValue(username).await()
            firebaseUser.toAuthUser(username)
        }.fold(
            onSuccess = { user -> Result.success(user) },
            onFailure = { error -> Result.failure(Exception(toUserFriendlyMessage(error, AuthContext.REGISTER), error)) }
        )
    }

    override suspend fun login(email: String, password: String): Result<AuthUser> {
        return runCatching {
            val firebaseUser = auth.signInWithEmailAndPassword(email, password).await().user
                ?: throw Exception("Login failed. Please try again.")
            val username = fetchUsername(firebaseUser.uid) ?: "Unknown User"
            firebaseUser.toAuthUser(username)
        }.fold(
            onSuccess = { user -> Result.success(user) },
            onFailure = { error -> Result.failure(Exception(toUserFriendlyMessage(error, AuthContext.LOGIN), error)) }
        )
    }

    override suspend fun getCurrentUser(): AuthUser? {
        val firebaseUser = auth.currentUser ?: return null
        return firebaseUser.toAuthUser(fetchUsername(firebaseUser.uid))
    }

    private suspend fun fetchUsername(uid: String): String? {
        // username is retrieved from the custom user data in the database under /users/$uid/username
        val usernameSnapshot = usersRef.child(uid).child("username").get().await()
        return usernameSnapshot.getValue(String::class.java) ?: "Unknown User"
    }

    private fun FirebaseUser.toAuthUser(username: String?): AuthUser =
        AuthUser(id = uid, email = email, username = username)

    private fun toUserFriendlyMessage(throwable: Throwable, context: AuthContext): String =
        when (throwable) {
            is FirebaseAuthInvalidCredentialsException,
            is FirebaseAuthInvalidUserException -> "Incorrect email or password"
            is FirebaseAuthUserCollisionException -> "This email is already registered"
            is FirebaseAuthWeakPasswordException -> "Password is too weak"
            is FirebaseNetworkException -> "Network error. Please check your connection."
            is DatabaseException -> "Could not load profile. Please try again."
            else -> context.fallbackMessage
        }
}
