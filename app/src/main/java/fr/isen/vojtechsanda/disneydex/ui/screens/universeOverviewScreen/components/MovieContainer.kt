package fr.isen.vojtechsanda.disneydex.ui.screens.universeOverviewScreen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import fr.isen.vojtechsanda.disneydex.domain.model.Movie

@Composable
fun MovieContainer(movie: Movie) {
    Column() {
        // TODO: Remove this once we have unified movie card
        Text(text = movie.name, color = Color.White)
        Text(text = movie.releaseDate.toString(), color = Color.White)
    }
}
