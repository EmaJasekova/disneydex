package fr.isen.vojtechsanda.disneydex.screens.registerScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import fr.isen.vojtechsanda.disneydex.components.AppHeader
import fr.isen.vojtechsanda.disneydex.components.authentication.AuthenticationHero
import fr.isen.vojtechsanda.disneydex.screens.loginScreen.components.LoginForm
import fr.isen.vojtechsanda.disneydex.screens.registerScreen.components.RegisterForm

@Composable
fun RegisterScreen(modifier: Modifier) {
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
                .padding(top = 68.dp, start = 24.dp, end = 24.dp, bottom = 10.dp),
        ) {
            RegisterForm()
        }
    }
}