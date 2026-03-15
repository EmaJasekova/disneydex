package fr.isen.vojtechsanda.disneydex.domain.repository

import fr.isen.vojtechsanda.disneydex.domain.model.MovieListType
import fr.isen.vojtechsanda.disneydex.domain.model.User

interface UserRepository {

    suspend fun getUser(uid: String): Result<User?>

    suspend fun saveUser(user: User): Result<Unit>

    suspend fun addMovieToList(movieId: String, list: MovieListType): Result<Unit>

    suspend fun removeMovieFromList(movieId: String, list: MovieListType): Result<Unit>

    suspend fun getMovieList(list: MovieListType): Result<List<String>>

    suspend fun isMovieInList(movieId: String, list: MovieListType): Result<Boolean>
}
