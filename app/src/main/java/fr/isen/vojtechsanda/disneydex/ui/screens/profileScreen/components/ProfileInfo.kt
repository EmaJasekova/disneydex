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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.isen.vojtechsanda.disneydex.domain.model.User
import fr.isen.vojtechsanda.disneydex.ui.components.common.UserAvatar
import fr.isen.vojtechsanda.disneydex.ui.theme.DarkGray
import fr.isen.vojtechsanda.disneydex.ui.utils.getYearFromMillis

@Composable
fun ProfileInfo(user: User) {
    Row(
        modifier = Modifier
            .padding(top = 16.dp, bottom = 32.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        UserAvatar(
            user, Modifier
                .size(120.dp)
                .border(
                    width = 1.5.dp,
                    color = DarkGray,
                    shape = CircleShape
                )
        )

        Spacer(Modifier.width(16.dp))

        Column(
            modifier = Modifier
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                user.username,
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(bottom = 4.dp),
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    imageVector = Icons.Default.Email,
                    contentDescription = "Email",
                    tint = Color.LightGray,
                    modifier = Modifier.size(16.dp)
                )
                Text(
                    user.email,
                    fontSize = 16.sp,
                    color = Color.LightGray,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
            }

            Text(
                fontSize = 14.sp,
                color = Color.Gray,
                text = "Member since ${getYearFromMillis(user.createdAt)}"
            )
        }
    }
}
