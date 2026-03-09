package fr.isen.vojtechsanda.disneydex.screens.loginScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import fr.isen.vojtechsanda.disneydex.components.authentication.AuthenticationHero
import fr.isen.vojtechsanda.disneydex.components.layout.PublicScaffold
import fr.isen.vojtechsanda.disneydex.screens.loginScreen.components.LoginForm

@Composable
fun LoginScreen() {
    PublicScaffold { modifier ->
        Column(
            modifier = modifier.fillMaxSize()
        ) {
            // Top Half (Hero Section)
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1.4f),
            ) {
                AuthenticationHero()
            }

            // Bottom Half (Form Section)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(2.6f)
                    .padding(top = 40.dp, start = 24.dp, end = 24.dp, bottom = 12.dp),
            ) {
                LoginForm()
            }
        }
    }
}
