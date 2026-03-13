package fr.isen.vojtechsanda.disneydex.ui.components.common.hero

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun HeroTitle(text: String) {
    Text(
        text,
        color = Color.White,
        fontWeight = FontWeight.Bold,
        fontSize = 48.sp,
        lineHeight = 52.sp,
    )
}
