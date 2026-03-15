package fr.isen.vojtechsanda.disneydex.ui.components.common

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import fr.isen.vojtechsanda.disneydex.domain.model.Movie
import fr.isen.vojtechsanda.disneydex.ui.theme.PaperColor

@Composable
fun MovieCard(
    movie: Movie,
    onDelete: (() -> Unit)? = null
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(PaperColor)
            .border(width = 1.dp, color = Color.DarkGray, shape = RoundedCornerShape(10.dp))
    ) {
        Row(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = movie.posterImage,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(80.dp)
                    .aspectRatio(2f / 3f)
                    .clip(RoundedCornerShape(8.dp))
            )

            Spacer(Modifier.width(12.dp))

            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
            ) {
                Column() {
                    Text(
                        movie.name,
                        fontSize = 24.sp,
                        lineHeight = 28.sp,
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.padding(bottom = 4.dp),
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                    Text(
                        color = LightGray,
                        text = "${movie.releaseDate.year} • ${movie.studio} •\n${movie.duration} min • ${movie.genre}"
                    )
                }

            }

            if (onDelete != null)
                DexActionButton(
                    onClick = onDelete,
                    icon = Icons.Filled.Close,
                    tint = LightGray,
                    size = 28.dp
                )
        }

    }

}
