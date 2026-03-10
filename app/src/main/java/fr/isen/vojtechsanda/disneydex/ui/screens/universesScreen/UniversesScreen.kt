package fr.isen.vojtechsanda.disneydex.ui.screens.universesScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import fr.isen.vojtechsanda.disneydex.R
import androidx.navigation.NavHostController
import fr.isen.vojtechsanda.disneydex.ui.components.layout.AuthedScaffold
import fr.isen.vojtechsanda.disneydex.ui.screens.universesScreen.components.UniverseCard

@Composable
fun UniversesScreen(navController: NavHostController) {
    AuthedScaffold ( navController = navController){ modifier ->
        Column(modifier) {

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
}

// Usage Example

//        UniverseCard(
//            title = "Marvel Cinematic",
//            subtitle = "Phase 1 - Phase 5",
//            badge = "New",
//            posterImages = listOf(R.drawable.poster1, R.drawable.poster2, R.drawable.poster3),
//            memberCount = 42,
//            onClick = { /* navigate */ }
//        )
