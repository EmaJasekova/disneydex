package fr.isen.vojtechsanda.disneydex.ui.screens.universesScreen.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import fr.isen.vojtechsanda.disneydex.ui.components.common.DexButton

@Composable

fun UniverseCardFooter(count: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 14.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        UniverseCardStackedAvatars(count = count)
        DexButton(
            onClick = {},
            colors = ButtonDefaults.buttonColors(containerColor = Color.White),
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
        ) { Text("Explore", color = Color.Black) }
    }
}
