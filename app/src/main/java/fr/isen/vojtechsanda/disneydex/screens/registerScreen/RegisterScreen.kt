package fr.isen.vojtechsanda.disneydex.screens.registerScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import fr.isen.vojtechsanda.disneydex.components.authentication.AuthenticationHero
import fr.isen.vojtechsanda.disneydex.screens.registerScreen.components.RegisterForm

@Composable
fun RegisterScreen(modifier: Modifier = Modifier) {
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
                .padding(start = 24.dp, end = 24.dp, bottom = 12.dp),
        ) {
            RegisterForm()
        }
    }
}