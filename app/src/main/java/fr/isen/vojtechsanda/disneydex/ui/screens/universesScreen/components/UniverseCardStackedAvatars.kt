package fr.isen.vojtechsanda.disneydex.ui.screens.universesScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
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
import fr.isen.vojtechsanda.disneydex.ui.theme.PaperColor

@Composable
fun UniverseCardStackedAvatars(
    count: Int,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        repeat(2) { index ->
            Box(
                modifier = Modifier
                    .offset(x = (-index * 8).dp)
                    .size(32.dp)
                    .clip(CircleShape)
                    .background(PaperColor)
                    .border(2.dp, Gray, CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = null,
                    tint = Gray,
                    modifier = Modifier.size(18.dp)
                )
            }
        }
        Box(
            modifier = Modifier
                .offset(x = (-16).dp)
                .size(32.dp)
                .clip(CircleShape)
                .background(Color(0xFF2A2A2A))
                .border(2.dp, Color(0xFF1E1E1E), CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Text("+$count", fontSize = 9.sp, fontWeight = FontWeight.Bold, color = Color.White)
        }
    }
}