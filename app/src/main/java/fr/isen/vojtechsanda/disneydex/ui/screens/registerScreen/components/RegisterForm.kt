package fr.isen.vojtechsanda.disneydex.ui.screens.registerScreen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import fr.isen.vojtechsanda.disneydex.AppContainer
import fr.isen.vojtechsanda.disneydex.ui.components.common.DexButton
import fr.isen.vojtechsanda.disneydex.ui.components.form.DexOutlinedTextField
import fr.isen.vojtechsanda.disneydex.ui.core.SnackbarController
import kotlinx.coroutines.launch

@Composable
fun RegisterForm(
    onRegister: () -> Unit
) {
    val scope = rememberCoroutineScope()

    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    val passwordTooShort = password.isNotEmpty() && password.length < 8
    val passwordMismatch = confirmPassword.isNotEmpty() && confirmPassword != password


    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DexOutlinedTextField(
            label = "Username",
            value = username,
            onValueChange = { username = it },
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(modifier = Modifier.height(8.dp))

        DexOutlinedTextField(
            label = "Email",
            value = email,
            onValueChange = { email = it },
            modifier = Modifier.fillMaxWidth(),
            keyboardType = KeyboardType.Email,
        )

        Spacer(modifier = Modifier.height(8.dp))

        DexOutlinedTextField(
            label = "Password",
            value = password,
            onValueChange = { password = it },
            modifier = Modifier.fillMaxWidth(),
            keyboardType = KeyboardType.Password,
            isError = passwordTooShort
        )

        Spacer(modifier = Modifier.height(8.dp))

        DexOutlinedTextField(
            label = "Confirm Password",
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            modifier = Modifier.fillMaxWidth(),
            keyboardType = KeyboardType.Password,
            isError = passwordMismatch
        )

        Spacer(modifier = Modifier.height(24.dp))

        DexButton(
            onClick = {
                scope.launch {
                    val result =
                        AppContainer.registerUseCase(
                            email = email,
                            username = username,
                            password = password
                        )

                    result.onSuccess {
                        username = ""
                        email = ""
                        password = ""
                        confirmPassword = ""

                        onRegister()
                    }.onFailure { error ->
                        SnackbarController.showSnackbar("Error: ${error.message}")
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
        ) {
            Text("Register", color = Color.White)
        }
    }
}
