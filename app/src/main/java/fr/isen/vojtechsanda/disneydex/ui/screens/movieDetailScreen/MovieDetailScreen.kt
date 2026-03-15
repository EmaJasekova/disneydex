package fr.isen.vojtechsanda.disneydex.ui.screens.movieDetailScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import fr.isen.vojtechsanda.disneydex.domain.model.Movie
import fr.isen.vojtechsanda.disneydex.ui.components.common.hero.Hero
import fr.isen.vojtechsanda.disneydex.ui.components.common.hero.HeroTitle
import fr.isen.vojtechsanda.disneydex.ui.components.layout.AuthedScaffold
import fr.isen.vojtechsanda.disneydex.ui.screens.movieDetailScreen.components.collectionStatusCard.CollectionStatusCard
import fr.isen.vojtechsanda.disneydex.ui.screens.movieDetailScreen.components.communityCard.CommunityCard
import java.time.LocalDate

@Composable
fun MovieDetailScreen(navController: NavHostController, movieId: String) {
    val movie = Movie(
        id = movieId,
        name = "Test movie 1",
        genre = "Sci-fi",
        duration = 189,
        studio = "Marvel",
        releaseDate = LocalDate.of(2023, 1, 1)
    )

    AuthedScaffold(
        navController = navController,
        hero = {
            Hero(imageUrl = movie.posterImage) {
                HeroTitle(
                    title = movie.name,
                    subtitle = "${movie.releaseDate.year} • ${movie.studio} • ${movie.duration} min • ${movie.genre}"
                )
            }
        },
        content = {
            Column(Modifier.padding(top = 12.dp)) {
                CollectionStatusCard()

                Spacer(Modifier.padding(vertical = 16.dp))

                CommunityCard(movie)
            }
        }
    )
}
