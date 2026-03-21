package fr.isen.vojtechsanda.disneydex.ui.screens.movieDetailScreen.components.communityCard

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import fr.isen.vojtechsanda.disneydex.AppContainer
import fr.isen.vojtechsanda.disneydex.domain.model.User
import fr.isen.vojtechsanda.disneydex.routing.Route
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class CommunityCardViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val movieId: String = savedStateHandle.toRoute<Route.MovieDetail>().movieId

    val movieTraders: StateFlow<List<User>?> =
        AppContainer.observeMovieTradersUseCase(movieId)
            .map { result ->
                result.getOrNull()?.filterNotNull() ?: emptyList()
            }
            .distinctUntilChanged()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.Eagerly,
                initialValue = null
            )

}
