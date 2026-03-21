package fr.isen.vojtechsanda.disneydex.ui.screens.registerScreen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import fr.isen.vojtechsanda.disneydex.ui.components.common.DexButton
import fr.isen.vojtechsanda.disneydex.ui.components.form.DexOutlinedTextField
import fr.isen.vojtechsanda.disneydex.ui.screens.registerScreen.RegisterViewModel

@Composable
fun RegisterForm(
    onRegister: () -> Unit,
    viewModel: RegisterViewModel = viewModel()
) {
    val state = viewModel.uiState

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DexOutlinedTextField(
            label = "Username",
            value = state.username,
            onValueChange = { viewModel.onUsernameChange(it) },
            modifier = Modifier.fillMaxWidth(),
            enabled = !state.isLoading
        )

        Spacer(modifier = Modifier.height(8.dp))

        DexOutlinedTextField(
            label = "Email",
            value = state.email,
            onValueChange = { viewModel.onEmailChange(it) },
            modifier = Modifier.fillMaxWidth(),
            keyboardType = KeyboardType.Email,
            enabled = !state.isLoading
        )

        Spacer(modifier = Modifier.height(8.dp))

        DexOutlinedTextField(
            label = "Password",
            value = state.password,
            onValueChange = { viewModel.onPasswordChange(it) },
            modifier = Modifier.fillMaxWidth(),
            keyboardType = KeyboardType.Password,
            enabled = !state.isLoading
        )

        Spacer(modifier = Modifier.height(8.dp))

        DexOutlinedTextField(
            label = "Confirm Password",
            value = state.confirmPassword,
            onValueChange = { viewModel.onConfirmPasswordChange(it) },
            modifier = Modifier.fillMaxWidth(),
            keyboardType = KeyboardType.Password,
            isError = state.isPasswordMismatch,
            supportingText = { if (state.isPasswordMismatch) Text("Passwords do not match") },
            enabled = !state.isLoading
        )

        Spacer(modifier = Modifier.height(24.dp))

        DexButton(
            onClick = { viewModel.register(onRegister) },
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            enabled = !state.isLoading
        ) {
            Text(
                text = if (state.isLoading) "Creating Account..." else "Register",
                color = Color.White
            )
        }
    }
}
