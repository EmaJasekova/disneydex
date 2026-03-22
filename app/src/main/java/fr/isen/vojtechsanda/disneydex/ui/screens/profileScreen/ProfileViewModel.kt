package fr.isen.vojtechsanda.disneydex.ui.screens.profileScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.isen.vojtechsanda.disneydex.AppContainer
import fr.isen.vojtechsanda.disneydex.domain.model.Movie
import fr.isen.vojtechsanda.disneydex.domain.model.MovieListType
import fr.isen.vojtechsanda.disneydex.domain.model.User
import fr.isen.vojtechsanda.disneydex.ui.core.SnackbarController
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel() {

    val currentUser: StateFlow<User?> = AppContainer.observeCurrentUserUseCase()
        .map { result -> result.getOrNull() }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = null
        )

    @OptIn(ExperimentalCoroutinesApi::class)
    val ownedMovies: StateFlow<List<Movie>?> = AppContainer
        .observeMovieListUseCase(MovieListType.OWNED)
        .flatMapLatest { ids ->
            if (ids.isEmpty()) {
                flowOf(emptyList())
            } else {
                AppContainer.observeMoviesUseCase(ids)
            }
        }
        .map { movies -> movies.filterNotNull() }
        .catch { emit(emptyList()) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = null
        )

    fun addToOwned(movie: Movie) {
        viewModelScope.launch {
            AppContainer.addMovieToListUseCase(movie.id, movieList = MovieListType.OWNED)
                .onFailure { error ->
                    SnackbarController.showSnackbar("Error: ${error.message}")
                }
        }
    }

    fun removeFromOwned(movie: Movie) {
        viewModelScope.launch {
            AppContainer.removeMovieFromListUseCase(movie.id, list = MovieListType.OWNED)
                .onFailure { error ->
                    SnackbarController.showSnackbar("Error: ${error.message}")
                }
        }
    }
}
