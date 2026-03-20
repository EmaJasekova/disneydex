package fr.isen.vojtechsanda.disneydex.ui.screens.movieDetailScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
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
import fr.isen.vojtechsanda.disneydex.ui.screens.movieDetailScreen.components.collectionStatusCard.CollectionStatusCard
import fr.isen.vojtechsanda.disneydex.ui.screens.movieDetailScreen.components.communityCard.CommunityCard

@Composable
fun MovieDetailScreen(
    navController: NavHostController,
    viewModel: MovieDetailViewModel = viewModel()
) {
    val movie by viewModel.movie.collectAsState()

    AuthedScaffold(
        navController = navController,
        hero = {
            movie?.let { m ->
                Hero(imageUrl = m.imageUrl) {
                    HeroTitle(
                        title = m.name,
                        subtitle = "${m.releaseDate.year} • ${m.studio} • ${m.duration} min • ${m.genre}"
                    )
                }
            }
        },
        content = {
            when (val m = movie) {
                null -> Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    CircularProgressIndicator()
                }
                else -> Column(Modifier.padding(top = 12.dp)) {
                    CollectionStatusCard()

                    Spacer(Modifier.padding(vertical = 16.dp))

                    CommunityCard(m)
                }
            }
        }
    )
}
