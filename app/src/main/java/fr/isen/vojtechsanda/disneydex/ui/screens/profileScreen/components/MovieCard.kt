package fr.isen.vojtechsanda.disneydex.ui.screens.profileScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import fr.isen.vojtechsanda.disneydex.domain.model.Movie
import fr.isen.vojtechsanda.disneydex.ui.components.common.DexActionButton
import fr.isen.vojtechsanda.disneydex.ui.theme.PaperColor

@Composable
fun MovieCard(
    movie: Movie,
    onDelete: () -> Unit = {}
) {
    val imageWeight = 0.30f

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .background(PaperColor)
            .border(width = 1.dp, color = Color.DarkGray, shape = RoundedCornerShape(8.dp))
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .weight(imageWeight)
                    .padding(4.dp)
            ) {
                AsyncImage(
                    model = movie.posterImage,
                    contentDescription = "Poster Image",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .size(80.dp)
                        .clip(RoundedCornerShape(10.dp))
                )
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(bottom = 8.dp, top = 8.dp)
            ) {
                Text(
                    fontSize = 16.sp,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(bottom = 4.dp),
                    text = movie.name
                )
                Text(
                    fontSize = 12.sp,
                    color = LightGray,
                    text = "${movie.releaseDate.year} - ${movie.studio} "
                )
                Text(
                    fontSize = 12.sp,
                    color = LightGray,
                    text = "${movie.genre} - ${movie.duration} min"
                )
            }

            DexActionButton(
                onClick = onDelete,
                icon = Icons.Default.Delete,
                tint = LightGray,
                size = 28.dp,
                contentDescription = "Delete movie"
            )
        }

    }

}