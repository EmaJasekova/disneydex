package fr.isen.vojtechsanda.disneydex.ui.screens.universeOverviewScreen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.toRoute
import fr.isen.vojtechsanda.disneydex.AppContainer
import fr.isen.vojtechsanda.disneydex.domain.model.Universe
import fr.isen.vojtechsanda.disneydex.routing.Route
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class UniverseOverviewViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val universeId: String = savedStateHandle.toRoute<Route.UniverseOverview>().universeId

    val universe: StateFlow<Universe?> = AppContainer.observeUniverseUseCase(universeId)
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = null
        )
}
