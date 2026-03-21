package fr.isen.vojtechsanda.disneydex.ui.screens.registerScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.isen.vojtechsanda.disneydex.AppContainer
import fr.isen.vojtechsanda.disneydex.ui.core.SnackbarController
import kotlinx.coroutines.launch

data class RegisterUiState(
    val username: String = "",
    val email: String = "",
    val password: String = "",
    val confirmPassword: String = "",
    val isLoading: Boolean = false
) {
    val isPasswordMismatch: Boolean = confirmPassword.isNotEmpty() && confirmPassword != password

    val canSubmit: Boolean = username.isNotBlank() &&
            email.isNotBlank() &&
            password.isNotBlank() &&
            password == confirmPassword &&
            !isLoading
}

class RegisterViewModel : ViewModel() {
    var uiState by mutableStateOf(RegisterUiState())
        private set

    fun onUsernameChange(value: String) {
        uiState = uiState.copy(username = value)
    }

    fun onEmailChange(value: String) {
        uiState = uiState.copy(email = value)
    }

    fun onPasswordChange(value: String) {
        uiState = uiState.copy(password = value)
    }

    fun onConfirmPasswordChange(value: String) {
        uiState = uiState.copy(confirmPassword = value)
    }

    fun register(onSuccess: () -> Unit) {
        viewModelScope.launch {
            if (!uiState.canSubmit) {
                SnackbarController.showSnackbar("Error: Invalid input")

                return@launch
            }

            uiState = uiState.copy(isLoading = true)

            val result = AppContainer.registerUseCase(
                email = uiState.email,
                username = uiState.username,
                password = uiState.password
            )

            uiState = uiState.copy(isLoading = false)

            result.onSuccess {
                SnackbarController.showSnackbar("Successfully registered!")
                uiState = RegisterUiState()
                onSuccess()
            }.onFailure { error ->
                SnackbarController.showSnackbar("Error: ${error.message}")
            }
        }
    }
}
