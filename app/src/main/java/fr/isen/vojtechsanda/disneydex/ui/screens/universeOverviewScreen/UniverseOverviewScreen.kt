package fr.isen.vojtechsanda.disneydex.ui.screens.universeOverviewScreen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import fr.isen.vojtechsanda.disneydex.ui.components.layout.AuthedScaffold

@Composable
fun UniverseOverviewScreen(universeId: String) {
    AuthedScaffold(
        content = {
            Text("This is universe with id $universeId")
        }
    )
}
