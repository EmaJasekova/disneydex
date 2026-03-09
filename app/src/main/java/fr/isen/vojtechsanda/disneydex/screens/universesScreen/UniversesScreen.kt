package fr.isen.vojtechsanda.disneydex.screens.universesScreen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import fr.isen.vojtechsanda.disneydex.components.layout.AuthedScaffold

@Composable
fun UniversesScreen() {
    AuthedScaffold(
        content = {
            Text("This is list of universes")
        }
    )
}
