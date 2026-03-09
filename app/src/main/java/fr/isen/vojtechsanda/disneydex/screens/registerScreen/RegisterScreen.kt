package fr.isen.vojtechsanda.disneydex.screens.registerScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import fr.isen.vojtechsanda.disneydex.components.AppHeader
import fr.isen.vojtechsanda.disneydex.screens.registerScreen.components.RegisterForm

@Composable
fun RegisterScreen(modifier: Modifier){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        AppHeader()
        RegisterForm()
    }
}