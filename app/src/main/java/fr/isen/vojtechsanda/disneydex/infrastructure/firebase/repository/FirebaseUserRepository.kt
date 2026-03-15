package fr.isen.vojtechsanda.disneydex.infrastructure.firebase.repository

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import fr.isen.vojtechsanda.disneydex.domain.exception.InvalidAuthStateException
import fr.isen.vojtechsanda.disneydex.domain.model.MovieListType
import fr.isen.vojtechsanda.disneydex.domain.model.User
import fr.isen.vojtechsanda.disneydex.domain.repository.UserRepository
import fr.isen.vojtechsanda.disneydex.infrastructure.firebase.FirebaseConstants
import fr.isen.vojtechsanda.disneydex.infrastructure.firebase.toFirebaseKey
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await

class FirebaseUserRepository : UserRepository {

    private companion object {
        const val LOG_TAG = "FirebaseUserRepository"
    }

    private val auth = FirebaseAuth.getInstance()
    private val usersRef = FirebaseDatabase.getInstance().getReference(FirebaseConstants.Paths.USERS)
    private val movieForTradeRef = FirebaseDatabase.getInstance().getReference(FirebaseConstants.Paths.MOVIE_FOR_TRADE)

    override suspend fun getUser(uid: String): Result<User?> = runCatching {
        val userSnapshot = usersRef.child(uid).get().await()
        if (!userSnapshot.exists()) return@runCatching null

        val firebaseUser = auth.currentUser?.takeIf { it.uid == uid }
        val email = firebaseUser?.email
            ?: userSnapshot.child("email").getValue(String::class.java)
            ?: throw InvalidAuthStateException("Email is required but was not provided by the authentication provider.")

        val username = userSnapshot.child("username").getValue(String::class.java) ?: "Disney Fan"
        val createdAt = userSnapshot.child("createdAt").getValue(Long::class.java)
            ?: firebaseUser?.metadata?.creationTimestamp
            ?: System.currentTimeMillis()

        User(
            uid = uid,
            email = email,
            username = username,
            createdAt = createdAt,
            watchedIds = readMovieIds(userSnapshot, MovieListType.WATCHED),
            watchlistIds = readMovieIds(userSnapshot, MovieListType.WATCHLIST),
            ownedIds = readMovieIds(userSnapshot, MovieListType.OWNED),
            forTradeIds = readMovieIds(userSnapshot, MovieListType.FOR_TRADE)
        )
    }

    override suspend fun saveUser(user: User): Result<Unit> = runCatching {
        val currentUser = auth.currentUser
            ?: throw InvalidAuthStateException("No authenticated user available to save profile data.")
        if (currentUser.uid != user.uid) {
            throw InvalidAuthStateException("Authenticated user does not match the profile being saved.")
        }
        usersRef.child(user.uid).child("username").setValue(user.username).await()
        usersRef.child(user.uid).child("createdAt").setValue(user.createdAt).await()
    }

    override suspend fun addMovieToList(movieId: String, list: MovieListType): Result<Unit> = runCatching {
        val uid = requireAuthenticatedUid()
        usersRef.child(uid).child(list.toFirebaseKey()).child(movieId).setValue(true).await()
        if (list == MovieListType.FOR_TRADE) {
            movieForTradeRef.child(movieId).child(uid).setValue(true).await()
        }
    }

    override suspend fun removeMovieFromList(movieId: String, list: MovieListType): Result<Unit> = runCatching {
        val uid = requireAuthenticatedUid()
        usersRef.child(uid).child(list.toFirebaseKey()).child(movieId).removeValue().await()
        if (list == MovieListType.FOR_TRADE) {
            movieForTradeRef.child(movieId).child(uid).removeValue().await()
        }
    }

    override fun observeMovieList(list: MovieListType): Flow<List<String>> = callbackFlow {
        val uid = requireAuthenticatedUid()
        val ref = usersRef.child(uid).child(list.toFirebaseKey())
        val listener = object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val ids = snapshot.children.mapNotNull { child -> child.key }
                trySend(ids)
            }

            override fun onCancelled(error: DatabaseError) {
                Log.e(LOG_TAG, error.toString())
                close(error.toException())
            }
        }
        ref.addValueEventListener(listener)
        awaitClose { ref.removeEventListener(listener) }
    }

    override suspend fun isMovieInList(movieId: String, list: MovieListType): Result<Boolean> = runCatching {
        val uid = requireAuthenticatedUid()
        val snapshot = usersRef.child(uid).child(list.toFirebaseKey()).child(movieId).get().await()
        snapshot.exists()
    }

    private fun requireAuthenticatedUid(): String =
        auth.currentUser?.uid
            ?: throw InvalidAuthStateException("User is not authenticated.")

    private fun readMovieIds(snapshot: DataSnapshot, list: MovieListType): List<String> =
        snapshot.child(list.toFirebaseKey()).children.mapNotNull { child -> child.key }
}
