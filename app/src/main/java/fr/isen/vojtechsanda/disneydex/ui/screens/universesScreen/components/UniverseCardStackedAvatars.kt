package fr.isen.vojtechsanda.disneydex.ui.screens.universesScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import fr.isen.vojtechsanda.disneydex.ui.theme.DarkGray
import fr.isen.vojtechsanda.disneydex.ui.theme.PaperColor

@Composable
fun UniverseCardStackedAvatars(
    avatars: List<String>,
    maxVisible: Int = 2,
    modifier: Modifier = Modifier
) {
    val visible = avatars.take(maxVisible)
    val overflow = (avatars.size - visible.size).coerceAtMost(99)

    Row(modifier = modifier) {
        visible.forEachIndexed { index, url ->
            Box(
                modifier = Modifier
                    .offset(x = (-index * 8).dp)
                    .size(32.dp)
                    .clip(CircleShape)
                    .background(PaperColor)
                    .border(2.dp, Gray, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                AsyncImage(
                    model = url,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )

            }
        }
        if (overflow > 0)
        Box(
            modifier = Modifier
                .offset(x = (-16).dp)
                .size(32.dp)
                .clip(CircleShape)
                .background(DarkGray)
                .border(2.dp, Gray, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text("+$overflow", fontSize = 9.sp, fontWeight = FontWeight.Bold, color = Color.White)
        }
    }
}