package fr.isen.vojtechsanda.disneydex.ui.components.common.hero

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HeroTitle(title: String, subtitle: String) {
    Column(
        verticalArrangement = Arrangement.Bottom,
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 32.dp)
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Text(
            title,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 48.sp,
            lineHeight = 52.sp,
        )
        Text(subtitle, color = Color.LightGray)
    }
}
