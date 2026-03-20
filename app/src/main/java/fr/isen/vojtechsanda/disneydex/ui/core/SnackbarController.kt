package fr.isen.vojtechsanda.disneydex.ui.core

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow

object SnackbarController {
    private val _events = Channel<String>()
    val events = _events.receiveAsFlow()

    fun showSnackbar(message: String) {
        _events.trySend(message)
    }
}
