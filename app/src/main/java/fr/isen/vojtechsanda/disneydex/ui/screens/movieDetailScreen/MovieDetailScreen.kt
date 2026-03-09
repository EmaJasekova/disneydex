package fr.isen.vojtechsanda.disneydex.ui.screens.movieDetailScreen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import fr.isen.vojtechsanda.disneydex.ui.components.layout.AuthedScaffold

@Composable
fun MovieDetailScreen(navController: NavHostController, movieId: String) {
    AuthedScaffold(
        navController = navController,
        content = {
            Text("This is movie with id $movieId")
        }
    )
}
