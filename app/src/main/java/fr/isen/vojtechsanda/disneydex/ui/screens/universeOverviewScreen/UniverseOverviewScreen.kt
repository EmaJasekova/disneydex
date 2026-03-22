package fr.isen.vojtechsanda.disneydex.ui.screens.universeOverviewScreen

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import fr.isen.vojtechsanda.disneydex.ui.components.common.DexLoader
import fr.isen.vojtechsanda.disneydex.ui.components.common.hero.Hero
import fr.isen.vojtechsanda.disneydex.ui.components.common.hero.HeroTitle
import fr.isen.vojtechsanda.disneydex.ui.components.layout.AuthedScaffold
import fr.isen.vojtechsanda.disneydex.ui.screens.universeOverviewScreen.components.sagaSection.sagaSection

@Composable
fun UniverseOverviewScreen(
    navController: NavHostController,
    viewModel: UniverseOverviewViewModel = viewModel()
) {
    val universeState by viewModel.universe.collectAsState()

    AuthedScaffold(
        navController = navController,
        disableScaffoldScrolling = true
    ) { innerPadding ->
        DexLoader(universeState) { universe ->
            LazyColumn() {
                item {
                    Hero(imageUrl = universeState?.imageUrls?.firstOrNull()) {
                        universeState?.let { universe ->
                            HeroTitle(
                                title = universe.name,
                                subtitle = universe.description
                            )
                        }
                    }
                }

                item { Spacer(Modifier.height(innerPadding.calculateTopPadding())) }

                universe.sagas.forEachIndexed { index, saga ->
                    sagaSection(
                        Modifier.padding(
                            start = innerPadding.calculateStartPadding(LayoutDirection.Ltr),
                            end = innerPadding.calculateEndPadding(LayoutDirection.Ltr)
                        ),
                        navController,
                        saga
                    )

                    if (index != universe.sagas.size - 1) {
                        item { Spacer(modifier = Modifier.height(40.dp)) }
                    }
                }

                item { Spacer(Modifier.height(innerPadding.calculateBottomPadding())) }
            }
        }
    }
}
