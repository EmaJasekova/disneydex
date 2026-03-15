package fr.isen.vojtechsanda.disneydex.ui.screens.universeOverviewScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import fr.isen.vojtechsanda.disneydex.domain.model.Movie
import fr.isen.vojtechsanda.disneydex.domain.model.Saga
import fr.isen.vojtechsanda.disneydex.domain.model.Universe
import fr.isen.vojtechsanda.disneydex.ui.components.common.hero.Hero
import fr.isen.vojtechsanda.disneydex.ui.components.common.hero.HeroTitle
import fr.isen.vojtechsanda.disneydex.ui.components.layout.AuthedScaffold
import fr.isen.vojtechsanda.disneydex.ui.screens.universeOverviewScreen.components.SagaContainer
import java.time.LocalDate

@Composable
fun UniverseOverviewScreen(navController: NavHostController, universeId: String) {
    val universe = Universe(
        id = universeId,
        name = "Pelíšky Dos Universe",
        description = "Short description 1",
        sagas = listOf(
            Saga(
                id = "test-saga-1",
                name = "Test saga 1",
                movies = listOf(
                    Movie(
                        id = "test-movie-1",
                        name = "Test movie 1",
                        genre = "Action",
                        duration = 120,
                        studio = "Lucasfilm",
                        releaseDate = LocalDate.of(2023, 1, 1)
                    ),
                    Movie(
                        id = "test-movie-3",
                        name = "Test movie 3",
                        genre = "Sci-fi",
                        duration = 189,
                        studio = "Marvel",
                        releaseDate = LocalDate.of(2024, 1, 1)
                    )
                )
            ),
            Saga(
                id = "test-saga-2",
                name = "Test saga 2",
                movies = listOf(
                    Movie(
                        id = "test-movie-2",
                        name = "Test movie 2",
                        genre = "Comedy",
                        studio = "Disney",
                        duration = 90,
                        releaseDate = LocalDate.of(2025, 2, 8)
                    )
                )
            )
        )
    );

    AuthedScaffold(
        navController = navController,
        hero = {
            Hero(imageUrl = universe.posterImages[0]) {
                Column(
                    verticalArrangement = Arrangement.Bottom,
                    modifier = Modifier
                        .padding(horizontal = 16.dp, vertical = 32.dp)
                        .fillMaxWidth()
                        .fillMaxHeight()
                ) {
                    HeroTitle(universe.name)
                    Text(universe.description, color = Color.White)
                }
            }
        },
        content = {
            Column(verticalArrangement = Arrangement.spacedBy(40.dp)) {
                universe.sagas.map { saga -> SagaContainer(saga) }
            }
        }
    )
}
