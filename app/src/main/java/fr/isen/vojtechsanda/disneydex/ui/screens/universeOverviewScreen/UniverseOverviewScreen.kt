package fr.isen.vojtechsanda.disneydex.ui.screens.universeOverviewScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import fr.isen.vojtechsanda.disneydex.ui.components.common.hero.Hero
import fr.isen.vojtechsanda.disneydex.ui.components.common.hero.HeroTitle
import fr.isen.vojtechsanda.disneydex.ui.components.layout.AuthedScaffold
import fr.isen.vojtechsanda.disneydex.ui.screens.universeOverviewScreen.components.SagaContainer

@Composable
fun UniverseOverviewScreen(
    navController: NavHostController,
    viewModel: UniverseOverviewViewModel = viewModel()
) {
    val universe by viewModel.universe.collectAsState()

    AuthedScaffold(
        navController = navController,
        hero = {
            universe?.let { u ->
                Hero(imageUrl = u.imageUrls.firstOrNull()) {
                    HeroTitle(title = u.name, subtitle = u.description)
                }
            }
        },
        content = {
            val u = universe
            when (u) {
                null -> Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
                else -> Column(verticalArrangement = Arrangement.spacedBy(40.dp)) {
                    u.sagas.map { saga ->
                        SagaContainer(navController, saga)
                    }
                }
            }
        }
    )
}
