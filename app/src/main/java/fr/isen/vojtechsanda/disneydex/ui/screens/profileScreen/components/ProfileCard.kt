package fr.isen.vojtechsanda.disneydex.ui.screens.profileScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import fr.isen.vojtechsanda.disneydex.domain.model.AuthUser

@Composable
fun ProfileCard(user: AuthUser, modifier: Modifier = Modifier) {
    val imageWeight = 0.28f

    Card(
        modifier = modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                // TODO: Connect to correct url
                model = "https://api.dicebear.com/9.x/lorelei/png?seed=1",
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(90.dp)
                    .height(90.dp)
                    .padding(8.dp)
            )

            Column(
                modifier = Modifier
                    .weight(1 - imageWeight),
                verticalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Text(
                    // TODO: Remove fallback when new models are done
                    user.username ?: "TODO: Bad model placeholder",
                    fontSize = 20.sp,
                    color = Color.White,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(bottom = 4.dp),
                )

                Row(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "Email",
                        tint = Color.LightGray,
                        modifier = Modifier.size(16.dp)
                    )
                    Text(
                        user.email ?: "TODO: Bad model placeholder",
                        fontSize = 16.sp,
                        color = Color.LightGray,
                    )
                }

                Text(
                    fontSize = 14.sp,
                    color = Color.LightGray,
                    // TODO: Connect to real year
                    text = "Joined in 2028"
                )
            }
        }

    }
}
