package fr.isen.vojtechsanda.disneydex.ui.screens.movieDetailScreen.components.communityCard

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.isen.vojtechsanda.disneydex.domain.model.Movie
import fr.isen.vojtechsanda.disneydex.domain.model.User
import fr.isen.vojtechsanda.disneydex.ui.components.common.UserAvatar
import fr.isen.vojtechsanda.disneydex.ui.theme.DarkGray
import fr.isen.vojtechsanda.disneydex.ui.theme.HighlightRed
import fr.isen.vojtechsanda.disneydex.ui.theme.InPaperColor

@Composable
fun CommunityUserCard(user: User, movie: Movie) {
    val context = LocalContext.current

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(InPaperColor)
            .fillMaxWidth()
            .border(1.dp, DarkGray, RoundedCornerShape(10.dp))
            .padding(12.dp),
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            UserAvatar(
                user, Modifier
                    .size(48.dp)
                    .border(
                        width = 1.dp,
                        color = DarkGray,
                        shape = CircleShape
                    )
            )

            Spacer(Modifier.width(12.dp))

            Column {
                Text(
                    text = user.username,
                    color = Color.White
                )

                Text("Physical Copy", color = Color.LightGray, fontSize = 14.sp)
            }
        }

        TextButton(onClick = {
            val intent = Intent(Intent.ACTION_SENDTO).apply {
                data =
                    Uri.parse("mailto:${user.email}?subject=${Uri.encode(movie.name)}")
            }

            context.startActivity(intent)
        }) {
            Text("Contact", color = HighlightRed)
        }
    }
}
