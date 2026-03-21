package fr.isen.vojtechsanda.disneydex.ui.screens.movieDetailScreen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import fr.isen.vojtechsanda.disneydex.AppContainer
import fr.isen.vojtechsanda.disneydex.domain.model.Movie
import fr.isen.vojtechsanda.disneydex.routing.Route
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class MovieDetailViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val movieId: String = savedStateHandle.toRoute<Route.MovieDetail>().movieId

    val movie: StateFlow<Movie?> = AppContainer.observeMovieUseCase(movieId)
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = null
        )

}
