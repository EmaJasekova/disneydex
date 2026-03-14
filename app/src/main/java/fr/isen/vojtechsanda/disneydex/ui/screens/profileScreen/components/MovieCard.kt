package fr.isen.vojtechsanda.disneydex.ui.screens.profileScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import fr.isen.vojtechsanda.disneydex.domain.model.Movie
import fr.isen.vojtechsanda.disneydex.ui.components.common.DexActionButton
import fr.isen.vojtechsanda.disneydex.ui.theme.DarkGray
import fr.isen.vojtechsanda.disneydex.ui.theme.MaroonRed

@Composable
fun MovieCard(
    movie: Movie,
    poster: String,
    onDelete: () -> Unit = {}
) {
    val imageWeight = 0.28f

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(DarkGray)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(132.dp)
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = poster,
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .weight(imageWeight)
                    .aspectRatio(1f / 2.2f)
                    .padding(8.dp)
                    .clip(RoundedCornerShape(24.dp))
            )
            Column(
                modifier = Modifier
                    .weight(1 - imageWeight)
                    .padding(8.dp)
            ) {
                Text(
                    fontSize = 20.sp,
                    color = Color.LightGray,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(bottom = 4.dp),
                    text = movie.name
                )
                Text(
                    fontSize = 12.sp,
                    color = Color.Gray,
                    text = movie.releaseDate.toString()
                )
            }

            DexActionButton(
                onClick = onDelete,
                icon = Icons.Default.Delete,
                tint = MaroonRed,
                size = 36.dp
            )
        }

    }

}