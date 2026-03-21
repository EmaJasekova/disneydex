package fr.isen.vojtechsanda.disneydex.ui.screens.movieDetailScreen.components.collectionStatusCard

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import fr.isen.vojtechsanda.disneydex.AppContainer
import fr.isen.vojtechsanda.disneydex.domain.model.MovieListType
import fr.isen.vojtechsanda.disneydex.routing.Route
import fr.isen.vojtechsanda.disneydex.ui.core.SnackbarController
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

data class CollectionListsUiState(
    val isOnWatchlist: Boolean,
    val isWatched: Boolean,
    val isOwned: Boolean,
    val isForTrade: Boolean
)

class CollectionStatusCardViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val movieId: String = savedStateHandle.toRoute<Route.MovieDetail>().movieId

    /**
     * Lists state
     */

    private fun isMovieInList(movieList: MovieListType): StateFlow<Boolean?> {
        return AppContainer.observeMovieListUseCase(movieList)
            .map { list -> list.contains(movieId) }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.Eagerly,
                initialValue = null
            )
    }

    private val isOnWatchlist: StateFlow<Boolean?> = isMovieInList(MovieListType.WATCHLIST)
    private val isWatched: StateFlow<Boolean?> = isMovieInList(MovieListType.WATCHED)
    private val isOwned: StateFlow<Boolean?> = isMovieInList(MovieListType.OWNED)
    private val isForTrade: StateFlow<Boolean?> = isMovieInList(MovieListType.FOR_TRADE)

    val collectionLists: StateFlow<CollectionListsUiState?> = combine(
        isOnWatchlist, isWatched, isOwned, isForTrade
    ) { watchlist, watched, owned, forTrade ->
        if (watchlist == null || watched == null || owned == null || forTrade == null) return@combine null

        CollectionListsUiState(
            isOnWatchlist = watchlist,
            isWatched = watched,
            isOwned = owned,
            isForTrade = forTrade
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.Eagerly,
        initialValue = null
    )

    /**
     * Lists updates
     */

    private fun updateList(movieList: MovieListType, value: Boolean) {
        viewModelScope.launch {
            if (value) {
                AppContainer.addMovieToListUseCase(movieId = movieId, movieList = movieList)
                    .onFailure { error ->
                        SnackbarController.showSnackbar("Error: ${error.message}")
                    }
            } else {
                AppContainer.removeMovieFromListUseCase(movieId = movieId, list = movieList)
                    .onFailure { error ->
                        SnackbarController.showSnackbar("Error: ${error.message}")
                    }
            }
        }
    }

    fun updateWatchlist(value: Boolean) {
        updateList(MovieListType.WATCHLIST, value)
    }

    fun updateWatchedList(value: Boolean) {
        updateList(MovieListType.WATCHED, value)
    }

    fun updateOwnedList(value: Boolean) {
        updateList(MovieListType.OWNED, value)
    }

    fun updateForTradeList(value: Boolean) {
        updateList(MovieListType.FOR_TRADE, value)
    }
}
