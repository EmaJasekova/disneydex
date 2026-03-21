package fr.isen.vojtechsanda.disneydex.ui.screens.universeOverviewScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import fr.isen.vojtechsanda.disneydex.ui.components.common.DexLoader
import fr.isen.vojtechsanda.disneydex.ui.components.common.hero.Hero
import fr.isen.vojtechsanda.disneydex.ui.components.common.hero.HeroTitle
import fr.isen.vojtechsanda.disneydex.ui.components.layout.AuthedScaffold
import fr.isen.vojtechsanda.disneydex.ui.screens.universeOverviewScreen.components.SagaContainer

@Composable
fun UniverseOverviewScreen(
    navController: NavHostController,
    viewModel: UniverseOverviewViewModel = viewModel()
) {
    val universeState by viewModel.universe.collectAsState()

    AuthedScaffold(
        navController = navController,
        hero = {
            Hero(imageUrl = universeState?.imageUrls?.firstOrNull()) {
                universeState?.let { universe ->
                    HeroTitle(
                        title = universe.name,
                        subtitle = universe.description
                    )
                }
            }
        },
    ) {
        DexLoader(universeState) { universe ->
            Column(verticalArrangement = Arrangement.spacedBy(40.dp)) {
                universe.sagas.map { saga ->
                    SagaContainer(navController, saga)
                }
            }
        }
    }
}
