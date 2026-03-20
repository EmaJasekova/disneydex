package fr.isen.vojtechsanda.disneydex.ui.screens.loginScreen.components

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
fun LoginForm(onLogin: () -> Unit) {
    val scope = rememberCoroutineScope()

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
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
        )

        Spacer(modifier = Modifier.height(24.dp))

        DexButton(
            onClick = {
                scope.launch {
                    val result = AppContainer.loginUseCase(email = email, password = password)

                    email = ""
                    password = ""

                    result.onSuccess {
                        onLogin()
                    }.onFailure { error ->
                        SnackbarController.showSnackbar("Error: ${error.message}")
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
        ) {
            Text("Login", color = Color.White)
        }
    }
}
