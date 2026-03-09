package fr.isen.vojtechsanda.disneydex.screens.movieDetailScreen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import fr.isen.vojtechsanda.disneydex.components.layout.AuthedScaffold

@Composable
fun MovieDetailScreen(movieId: String) {
    AuthedScaffold(
        content = {
            Text("This is movie with id $movieId")
        }
    )
}
