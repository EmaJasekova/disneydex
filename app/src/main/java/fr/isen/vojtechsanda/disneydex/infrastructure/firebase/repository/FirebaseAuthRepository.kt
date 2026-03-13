package fr.isen.vojtechsanda.disneydex.infrastructure.firebase.repository

import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import fr.isen.vojtechsanda.disneydex.domain.model.AuthCredential
import fr.isen.vojtechsanda.disneydex.domain.model.AuthContext
import fr.isen.vojtechsanda.disneydex.domain.repository.AuthRepository
import kotlinx.coroutines.tasks.await

class FirebaseAuthRepository : AuthRepository {

    private val auth = FirebaseAuth.getInstance()

    override suspend fun register(email: String, password: String): Result<AuthCredential> {
        return runCatching {
            val firebaseUser = auth.createUserWithEmailAndPassword(email, password).await().user
                ?: throw Exception("Registration failed. Please try again later.")
            AuthCredential(uid = firebaseUser.uid, email = firebaseUser.email)
        }.fold(
            onSuccess = { credential -> Result.success(credential) },
            onFailure = { error -> Result.failure(Exception(toUserFriendlyMessage(error, AuthContext.REGISTER), error)) }
        )
    }

    override suspend fun login(email: String, password: String): Result<AuthCredential> {
        return runCatching {
            val firebaseUser = auth.signInWithEmailAndPassword(email, password).await().user
                ?: throw Exception("Login failed. Please try again later.")
            AuthCredential(uid = firebaseUser.uid, email = firebaseUser.email)
        }.fold(
            onSuccess = { credential -> Result.success(credential) },
            onFailure = { error -> Result.failure(Exception(toUserFriendlyMessage(error, AuthContext.LOGIN), error)) }
        )
    }

    override suspend fun logout(): Result<Unit> = runCatching {
        auth.signOut()
    }.fold(
        onSuccess = { Result.success(Unit) },
        onFailure = { error -> Result.failure(Exception(toUserFriendlyMessage(error, AuthContext.LOGOUT), error)) }
    )

    override suspend fun getCurrentUser(): AuthCredential? {
        val firebaseUser = auth.currentUser ?: return null
        return AuthCredential(uid = firebaseUser.uid, email = firebaseUser.email)
    }

    private fun toUserFriendlyMessage(throwable: Throwable, context: AuthContext): String =
        when (throwable) {
            is FirebaseAuthInvalidCredentialsException,
            is FirebaseAuthInvalidUserException -> "Incorrect email or password"
            is FirebaseAuthUserCollisionException -> "This email is already registered"
            is FirebaseAuthWeakPasswordException -> "Password is too weak"
            is FirebaseNetworkException -> "Network error. Please check your connection."
            else -> context.fallbackMessage
        }
}
