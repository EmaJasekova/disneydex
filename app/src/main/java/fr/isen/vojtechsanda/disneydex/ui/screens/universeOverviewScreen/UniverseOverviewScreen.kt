package fr.isen.vojtechsanda.disneydex.ui.screens.universeOverviewScreen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import fr.isen.vojtechsanda.disneydex.ui.components.layout.AuthedScaffold

@Composable
fun UniverseOverviewScreen(navController: NavHostController, universeId: String) {
    AuthedScaffold(
        navController = navController,
        content = {
            Text("This is universe with id $universeId")
        }
    )
}
