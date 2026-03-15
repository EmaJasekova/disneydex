package fr.isen.vojtechsanda.disneydex.ui.screens.profileScreen.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Camera
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CollectionTitle() {
    Column {
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Icon(
                imageVector = Icons.Default.Camera,
                contentDescription = null,
                tint = Color.White
            )
            Text(
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(bottom = 4.dp),
                text = "Your Collection"
            )
        }

        Text(
            fontSize = 16.sp,
            color = Color.LightGray,
            text = "Movies you own on DVD or Blu-Ray."
        )
    }
}
