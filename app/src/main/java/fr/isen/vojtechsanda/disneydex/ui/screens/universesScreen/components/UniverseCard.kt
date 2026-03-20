package fr.isen.vojtechsanda.disneydex.ui.screens.universesScreen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import fr.isen.vojtechsanda.disneydex.domain.model.User
import fr.isen.vojtechsanda.disneydex.ui.components.common.DexCard

@Composable
fun UniverseCard(
    title: String,
    description: String,
    imageUrls: List<String>,
    users: List<User>,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
) {
    DexCard(modifier = modifier.clickable { onClick() }) {
        Column {
            UniverseCardTitle(title = title, description = description)

            Spacer(Modifier.height(20.dp))

            UniverseCardImageGrid(imageUrls = imageUrls)

            Spacer(Modifier.height(24.dp))

            UniverseCardFooter(users, onExploreClick = onClick)
        }
    }
}
