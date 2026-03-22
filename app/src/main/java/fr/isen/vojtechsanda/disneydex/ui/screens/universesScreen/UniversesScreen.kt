package fr.isen.vojtechsanda.disneydex.ui.screens.universesScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import fr.isen.vojtechsanda.disneydex.routing.Route
import fr.isen.vojtechsanda.disneydex.ui.components.common.DexLoader
import fr.isen.vojtechsanda.disneydex.ui.components.layout.AuthedScaffold
import fr.isen.vojtechsanda.disneydex.ui.screens.universesScreen.components.UniverseCard

@Composable
fun UniversesScreen(
    navController: NavHostController,
    viewModel: UniversesViewModel = viewModel()
) {
    val universesState by viewModel.universes.collectAsState()

    AuthedScaffold(
        navController = navController,
        disableScaffoldScrolling = true
    ) { innerPadding ->
        DexLoader(universesState) { universes ->
            LazyColumn(
                contentPadding = innerPadding,
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                items(items = universes, key = { universe -> universe.id }) { universe ->
                    UniverseCard(
                        universe = universe,
                        onClick = { navController.navigate(Route.UniverseOverview(universe.id)) }
                    )
                }
            }
        }
    }
}
