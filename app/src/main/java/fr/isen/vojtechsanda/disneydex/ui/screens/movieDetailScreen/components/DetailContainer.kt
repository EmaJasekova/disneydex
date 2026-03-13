package fr.isen.vojtechsanda.disneydex.ui.screens.movieDetailScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.isen.vojtechsanda.disneydex.ui.theme.DarkGray
import fr.isen.vojtechsanda.disneydex.ui.theme.PaperColor

@Composable
fun DetailContainer(
    title: String,
    content: @Composable () -> Unit,
) {
    // TODO: Unifikovat kartu na universes stránce s kartami jinde
    Column(
        modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(PaperColor)
            .border(width = 1.dp, color = DarkGray, shape = RoundedCornerShape(10.dp))
            .padding(24.dp)
            .fillMaxWidth()

    ) {
        Text(
            title,
            Modifier.padding(bottom = 20.dp),
            color = Color.White,
            fontSize = 20.sp,
            lineHeight = 24.sp
        )

        content()
    }
}
