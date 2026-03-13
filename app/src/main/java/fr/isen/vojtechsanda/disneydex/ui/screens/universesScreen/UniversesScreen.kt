package fr.isen.vojtechsanda.disneydex.ui.screens.universesScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import fr.isen.vojtechsanda.disneydex.R
import fr.isen.vojtechsanda.disneydex.ui.components.layout.AuthedScaffold
import fr.isen.vojtechsanda.disneydex.ui.screens.universesScreen.components.UniverseCard

@Composable
fun UniversesScreen(navController: NavHostController) {
    AuthedScaffold(
        navController = navController,
        {
            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {

            UniverseCard(
                title = "Marvel Cinematic",
                subtitle = "Phase 1 - Phase 5",
                posterImages = listOf(R.drawable.poster1, R.drawable.poster2, R.drawable.poster3),
                count = 12
            )

            UniverseCard(
                title = "Marvel Cinematic",
                subtitle = "Phase 1 - Phase 5",
                posterImages = listOf(R.drawable.poster1, R.drawable.poster2, R.drawable.poster3),
                count = 12
            )

            UniverseCard(
                title = "Marvel Cinematic",
                subtitle = "Phase 1 - Phase 5",
                posterImages = listOf(R.drawable.poster1, R.drawable.poster2, R.drawable.poster3),
                count = 12
            )
        }
        }
    )
}