package fr.isen.vojtechsanda.disneydex.domain.repository

import fr.isen.vojtechsanda.disneydex.domain.model.MovieListType
import fr.isen.vojtechsanda.disneydex.domain.model.User
import kotlinx.coroutines.flow.Flow

// TODO(Low): Inconsistent Result vs nullable - getUser returns Flow<Result<User?>>, getUsers returns Flow<List<User?>>. Standardize on one approach.
interface UserRepository {

    fun getUser(uid: String): Flow<Result<User?>>

    fun getUsers(uids: List<String>): Flow<List<User?>>

    suspend fun saveUser(user: User): Result<Unit>

    suspend fun addMovieToList(movieId: String, list: MovieListType): Result<Unit>

    suspend fun removeMovieFromList(movieId: String, list: MovieListType): Result<Unit>

    fun observeMovieList(list: MovieListType): Flow<List<String>>

    suspend fun isMovieInList(movieId: String, list: MovieListType): Result<Boolean>
}
