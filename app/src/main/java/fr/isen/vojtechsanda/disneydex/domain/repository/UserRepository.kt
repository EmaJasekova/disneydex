package fr.isen.vojtechsanda.disneydex.domain.repository

import fr.isen.vojtechsanda.disneydex.domain.model.MovieListType
import fr.isen.vojtechsanda.disneydex.domain.model.User
import kotlinx.coroutines.flow.Flow

/**
 * Repository for user data operations.
 *
 * [observeUser] and [observeUsers] operate on any user(s) by uid.
 * All other operations (saveUser, addMovieToList, removeMovieFromList, observeMovieList, isMovieInList)
 * require authentication and are performed for the currently authorized user.
 */

interface UserRepository {

    fun observeUser(uid: String): Flow<Result<User?>>

    fun observeUsers(uids: List<String>): Flow<Result<List<User?>>>

    fun observeCurrentUser(): Flow<Result<User?>>

    suspend fun saveUser(user: User): Result<Unit>

    suspend fun addMovieToList(movieId: String, list: MovieListType): Result<Unit>

    suspend fun removeMovieFromList(movieId: String, list: MovieListType): Result<Unit>

    fun observeMovieList(list: MovieListType): Flow<List<String>>

    suspend fun isMovieInList(movieId: String, list: MovieListType): Result<Boolean>
}
