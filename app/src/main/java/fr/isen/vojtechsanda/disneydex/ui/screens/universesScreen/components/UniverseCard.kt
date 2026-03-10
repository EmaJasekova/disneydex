package fr.isen.vojtechsanda.disneydex.ui.screens.universesScreen.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import fr.isen.vojtechsanda.disneydex.ui.theme.BorderColorRed

@Composable
fun UniverseCard(
    title: String, subtitle: String, posterImages: List<Int>, count: Int

) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                // TODO: Handle dynamic routing to the universe overview screen
            },
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFF1E1E1E)),
        border = BorderStroke(1.dp, BorderColorRed)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            UniverseCardTitle(title = title, subtitle = subtitle)
            UniverseCardImageGrid(posterImages = posterImages)
            UniverseCardFooter(count = count)
        }

    }
}