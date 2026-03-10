package fr.isen.vojtechsanda.disneydex.ui.screens.universesScreen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UniverseCardTitle(title: String, subtitle: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 14.dp),
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = title,
            fontSize = 28.sp,
            color = Color.Gray,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(bottom = 6.dp),
        )
        Text(
            text = subtitle,
            fontSize = 20.sp,
            color = Color.LightGray,
        )
    }
}
