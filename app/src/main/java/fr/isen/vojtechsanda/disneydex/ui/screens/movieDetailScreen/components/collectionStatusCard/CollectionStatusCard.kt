package fr.isen.vojtechsanda.disneydex.ui.screens.movieDetailScreen.components.collectionStatusCard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import fr.isen.vojtechsanda.disneydex.ui.components.common.DexLoader
import fr.isen.vojtechsanda.disneydex.ui.screens.movieDetailScreen.components.DetailContainer

@Composable
fun CollectionStatusCard(viewModel: CollectionStatusCardViewModel = viewModel()) {
    val collectionStatusesState by viewModel.collectionLists.collectAsState()

    DetailContainer(title = "Collection status") {
        DexLoader(collectionStatusesState) { collectionStatuses ->
            Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                CollectionStatusRow(
                    title = "Want to watch",
                    value = collectionStatuses.isOnWatchlist,
                    onValueChange = { viewModel.updateWatchlist(it) }
                )

                CollectionStatusRow(
                    title = "Watched",
                    value = collectionStatuses.isWatched,
                    onValueChange = { viewModel.updateWatchedList(it) }
                )

                CollectionStatusRow(
                    title = "Own on Physical Media",
                    value = collectionStatuses.isOwned,
                    onValueChange = { viewModel.updateOwnedList(it) }
                )

                if (collectionStatuses.isOwned)
                    CollectionStatusRow(
                        title = "Available for Trade",
                        value = collectionStatuses.isForTrade,
                        onValueChange = { viewModel.updateForTradeList(it) }
                    )
            }
        }
    }
}
