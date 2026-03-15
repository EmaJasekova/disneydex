package fr.isen.vojtechsanda.disneydex.ui.screens.profileScreen.components

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.isen.vojtechsanda.disneydex.domain.model.AuthUser
import fr.isen.vojtechsanda.disneydex.ui.components.common.DexCard
import fr.isen.vojtechsanda.disneydex.ui.components.common.UserAvatar
import fr.isen.vojtechsanda.disneydex.ui.theme.DarkGray

@Composable
fun ProfileCard(user: AuthUser, modifier: Modifier = Modifier) {
    val imageWeight = 0.28f

    DexCard(
        modifier = modifier
            .fillMaxWidth(),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            UserAvatar(
                user, Modifier
                    .size(100.dp)
                    .border(
                        width = 1.5.dp,
                        color = DarkGray,
                        shape = CircleShape
                    )
            )

            Spacer(Modifier.width(12.dp))

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
