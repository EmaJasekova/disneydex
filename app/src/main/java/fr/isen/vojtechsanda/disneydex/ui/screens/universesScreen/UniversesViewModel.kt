package fr.isen.vojtechsanda.disneydex.ui.screens.universesScreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.isen.vojtechsanda.disneydex.AppContainer
import fr.isen.vojtechsanda.disneydex.domain.model.Universe
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn

class UniversesViewModel : ViewModel() {

    val universes: StateFlow<List<Universe>?> = AppContainer.observeUniversesUseCase()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = null
        )
}
