package fr.isen.vojtechsanda.disneydex.ui.components.common

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit

@Composable
fun TextLogo(
    fontSize: TextUnit = TextUnit.Unspecified,
    color: Color = Color.White,
    modifier: Modifier = Modifier,
) {
    Row(modifier) {
        Text(
            text = "Disney",
            fontSize = fontSize,
            color = color,
        )

        Text(
            text = "dex",
            fontWeight = FontWeight.Bold,
            fontSize = fontSize,
            color = color,
        )
    }
}
