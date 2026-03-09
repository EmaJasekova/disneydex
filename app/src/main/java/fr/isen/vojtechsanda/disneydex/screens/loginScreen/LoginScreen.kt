package fr.isen.vojtechsanda.disneydex.screens.loginScreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import fr.isen.vojtechsanda.disneydex.components.AppHeader
import fr.isen.vojtechsanda.disneydex.components.authentication.AuthenticationHero
import fr.isen.vojtechsanda.disneydex.screens.loginScreen.components.LoginForm
import fr.isen.vojtechsanda.disneydex.screens.registerScreen.components.RegisterForm

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // Top Half (Hero Section)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
        ) {
            AuthenticationHero()
        }

        // Bottom Half (Form Section)
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(2.8f)
                .padding(top = 40.dp, start=24.dp, end = 24.dp, bottom = 10.dp),
        ) {
           LoginForm()
        }
    }
}