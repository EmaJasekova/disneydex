package fr.isen.vojtechsanda.disneydex.ui.screens.movieDetailScreen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.isen.vojtechsanda.disneydex.ui.components.common.DexCard

@Composable
fun DetailContainer(
    title: String,
    content: @Composable () -> Unit,
) {
    DexCard(modifier = Modifier.fillMaxWidth(), padding = 24.dp) {
        Column {
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
}
