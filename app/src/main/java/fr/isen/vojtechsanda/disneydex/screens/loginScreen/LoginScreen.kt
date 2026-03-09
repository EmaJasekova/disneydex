package fr.isen.vojtechsanda.disneydex.screens.loginScreen

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import fr.isen.vojtechsanda.disneydex.components.authentication.AuthenticationHero
import fr.isen.vojtechsanda.disneydex.screens.loginScreen.components.LoginForm

@Composable
fun LoginScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        // Top Half (Hero Section)
        Box(
            modifier = modifier
                .fillMaxWidth()
                .weight(1.4f),
        ) {
            AuthenticationHero()
        }
        // Bottom Half (Form Section)
        Column(
            modifier = modifier
                .fillMaxWidth()
                .weight(2.6f)
                .padding(top = 40.dp, start = 24.dp, end = 24.dp, bottom = 12.dp),
        ) {
            LoginForm()
        }
    }
}