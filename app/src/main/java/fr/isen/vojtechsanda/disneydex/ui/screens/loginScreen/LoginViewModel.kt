package fr.isen.vojtechsanda.disneydex.ui.screens.loginScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.isen.vojtechsanda.disneydex.AppContainer
import fr.isen.vojtechsanda.disneydex.ui.core.SnackbarController
import kotlinx.coroutines.launch

data class LoginUiState(
    val email: String = "",
    val password: String = "",
    val isLoading: Boolean = false
)

class LoginViewModel : ViewModel() {
    var uiState by mutableStateOf(LoginUiState())
        private set

    fun onEmailChange(newValue: String) {
        uiState = uiState.copy(email = newValue)
    }

    fun onPasswordChange(newValue: String) {
        uiState = uiState.copy(password = newValue)
    }

    fun login(onSuccess: () -> Unit) {
        viewModelScope.launch {
            uiState = uiState.copy(isLoading = true)

            val result = AppContainer.loginUseCase(
                email = uiState.email,
                password = uiState.password
            )

            uiState = uiState.copy(isLoading = false)

            result.onSuccess {
                uiState = LoginUiState()
                onSuccess()
            }.onFailure { error ->
                SnackbarController.showSnackbar("Error: ${error.message}")
            }
        }
    }
}
