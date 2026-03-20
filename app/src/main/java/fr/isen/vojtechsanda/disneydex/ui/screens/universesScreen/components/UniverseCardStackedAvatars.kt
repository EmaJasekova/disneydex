package fr.isen.vojtechsanda.disneydex.ui.screens.universesScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.isen.vojtechsanda.disneydex.domain.model.User
import fr.isen.vojtechsanda.disneydex.ui.components.common.UserAvatar
import fr.isen.vojtechsanda.disneydex.ui.theme.DarkGray

@Composable
fun UniverseCardStackedAvatars(
    users: List<User>,
    maxVisible: Int = 2,
    modifier: Modifier = Modifier
) {
    val visible = users.take(maxVisible)
    val overflow = (users.size - visible.size).coerceAtMost(99)

    Row(modifier = modifier) {
        visible.forEachIndexed { index, user ->
            Modifier.size(32.dp)
            UserAvatar(
                user,
                Modifier
                    .offset(x = (-index * 8).dp)
                    .size(32.dp)
                    .border(2.dp, Gray, CircleShape)
            )
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
                Text(
                    "+$overflow",
                    fontSize = 9.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
    }
}
