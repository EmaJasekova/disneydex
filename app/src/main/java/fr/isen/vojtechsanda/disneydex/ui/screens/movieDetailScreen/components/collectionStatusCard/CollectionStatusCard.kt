package fr.isen.vojtechsanda.disneydex.ui.screens.movieDetailScreen.components.collectionStatusCard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import fr.isen.vojtechsanda.disneydex.AppContainer
import fr.isen.vojtechsanda.disneydex.domain.model.Movie
import fr.isen.vojtechsanda.disneydex.domain.model.MovieListType
import fr.isen.vojtechsanda.disneydex.ui.core.SnackbarController
import fr.isen.vojtechsanda.disneydex.ui.screens.movieDetailScreen.components.DetailContainer
import kotlinx.coroutines.launch

@Composable
fun CollectionStatusCard(movie: Movie) {
    val scope = rememberCoroutineScope()

    var wantToWatchState by remember { mutableStateOf(false) }
    var watchedState by remember { mutableStateOf(false) }
    var ownOnPhysicalMediaState by remember { mutableStateOf(false) }
    var availableForTradeState by remember { mutableStateOf(false) }

    fun updateList(movieList: MovieListType, value: Boolean) {
        scope.launch {
            if (value) {
                AppContainer.addMovieToListUseCase(movieId = movie.id, movieList = movieList)
                    .onFailure { error ->
                        SnackbarController.showSnackbar("Error: ${error.message}")
                    }
            } else {
                AppContainer.removeMovieFromListUseCase(movieId = movie.id, list = movieList)
                    .onFailure { error ->
                        SnackbarController.showSnackbar("Error: ${error.message}")
                    }
            }
        }
    }

    DetailContainer(title = "Collection status") {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            CollectionStatusRow(
                title = "Want to watch",
                value = wantToWatchState,
                onValueChange = { updateList(MovieListType.WATCHLIST, it) }
            )

            CollectionStatusRow(
                title = "Watched",
                value = watchedState,
                onValueChange = { updateList(MovieListType.WATCHED, it) }
            )

            CollectionStatusRow(
                title = "Own on Physical Media",
                value = ownOnPhysicalMediaState,
                onValueChange = { updateList(MovieListType.OWNED, it) }
            )

            if (ownOnPhysicalMediaState)
                CollectionStatusRow(
                    title = "Available for Trade",
                    value = availableForTradeState,
                    onValueChange = { updateList(MovieListType.FOR_TRADE, it) }
                )
        }
    }
}
