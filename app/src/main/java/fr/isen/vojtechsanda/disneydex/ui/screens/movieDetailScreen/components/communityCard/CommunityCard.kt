package fr.isen.vojtechsanda.disneydex.ui.screens.movieDetailScreen.components.communityCard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import fr.isen.vojtechsanda.disneydex.domain.model.Movie
import fr.isen.vojtechsanda.disneydex.extensions.list.sliceSafe
import fr.isen.vojtechsanda.disneydex.ui.components.common.DexLoader
import fr.isen.vojtechsanda.disneydex.ui.screens.movieDetailScreen.components.DetailContainer

@Composable
fun CommunityCard(movie: Movie, viewModel: CommunityCardViewModel = viewModel()) {
    val movieTradersState by viewModel.movieTraders.collectAsState()

    DetailContainer(title = "Available from community") {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            DexLoader(movieTradersState) { traders ->
                val visibleTraders =
                    traders.sliceSafe(
                        viewModel.currentOffset,
                        viewModel.currentOffset + viewModel.pageSize
                    )

                if (visibleTraders.isEmpty()) {
                    Text(
                        text = "There are no copies of this movie available.",
                        color = Color.LightGray
                    )
                }

                visibleTraders.map { trader -> CommunityUserCard(trader, movie) }

                if (viewModel.canGoBack() || viewModel.canGoNext(traders.size)) {
                    CommunityCardFooter(totalOffers = traders.size)
                }
            }
        }
    }
}
