package fr.isen.vojtechsanda.disneydex.ui.screens.movieDetailScreen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import fr.isen.vojtechsanda.disneydex.ui.components.layout.AuthedScaffold

@Composable
fun MovieDetailScreen(movieId: String) {
    AuthedScaffold(
        content = {
            Text("This is movie with id $movieId")
        }
    )
}
