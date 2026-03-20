package fr.isen.vojtechsanda.disneydex.ui.screens.movieDetailScreen.components.collectionStatusCard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import fr.isen.vojtechsanda.disneydex.ui.screens.movieDetailScreen.components.DetailContainer

@Composable
fun CollectionStatusCard() {
    var wantToWatchState by remember { mutableStateOf(true) }
    var watchedState by remember { mutableStateOf(false) }
    var ownOnPhysicalMediaState by remember { mutableStateOf(false) }
    var availableForTradeState by remember { mutableStateOf(false) }

    DetailContainer(title = "Collection status") {
        Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
            // TODO: Connect value, handling
            CollectionStatusRow(
                title = "Want to watch",
                value = wantToWatchState,
                onValueChange = { wantToWatchState = it }
            )

            CollectionStatusRow(
                title = "Watched",
                value = watchedState,
                onValueChange = { watchedState = it }
            )

            CollectionStatusRow(
                title = "Own on Physical Media",
                value = ownOnPhysicalMediaState,
                onValueChange = { ownOnPhysicalMediaState = it }
            )

            if (ownOnPhysicalMediaState)
                CollectionStatusRow(
                    title = "Available for Trade",
                    value = availableForTradeState,
                    onValueChange = { availableForTradeState = it }
                )
        }
    }
}
