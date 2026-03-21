package fr.isen.vojtechsanda.disneydex.ui.screens.movieDetailScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import fr.isen.vojtechsanda.disneydex.ui.components.common.DexLoader
import fr.isen.vojtechsanda.disneydex.ui.components.common.hero.Hero
import fr.isen.vojtechsanda.disneydex.ui.components.common.hero.HeroTitle
import fr.isen.vojtechsanda.disneydex.ui.components.layout.AuthedScaffold
import fr.isen.vojtechsanda.disneydex.ui.screens.movieDetailScreen.components.collectionStatusCard.CollectionStatusCard
import fr.isen.vojtechsanda.disneydex.ui.screens.movieDetailScreen.components.communityCard.CommunityCard

@Composable
fun MovieDetailScreen(
    navController: NavHostController,
    viewModel: MovieDetailViewModel = viewModel()
) {
    val movieState by viewModel.movie.collectAsState()

    AuthedScaffold(
        navController = navController,
        hero = {
            Hero(imageUrl = movieState?.imageUrl) {
                movieState?.let { movie ->
                    HeroTitle(
                        title = movie.name,
                        subtitle = "${movie.releaseDate.year} • ${movie.studio} • ${movie.duration} min • ${movie.genre}"
                    )
                }
            }
        },
    ) {
        DexLoader(movieState) { movie ->
            Column(Modifier.padding(top = 12.dp)) {
                CollectionStatusCard()

                Spacer(Modifier.padding(vertical = 16.dp))

                CommunityCard(movie)
            }

        }
    }
}
