package fr.isen.vojtechsanda.disneydex.ui.screens.movieDetailScreen.components.collectionStatusCard

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import fr.isen.vojtechsanda.disneydex.ui.theme.HighlightRed
import fr.isen.vojtechsanda.disneydex.ui.theme.InPaperColor

@Composable
fun CollectionStatusRow(
    title: String,
    value: Boolean,
    onValueChange: (Boolean) -> Unit,
) {

    Row(
        Modifier
            .clip(RoundedCornerShape(10.dp))
            .background(if (value) InPaperColor else Color.Transparent)
            .fillMaxWidth()
            .toggleable(
                value = value,
                onValueChange = { onValueChange(it) },
            )
            .padding(12.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = title,
            color = if (value) Color.White else Color.LightGray,
        )

        Checkbox(
            checked = value,
            onCheckedChange = null,
            colors = CheckboxDefaults.colors(
                checkedColor = HighlightRed,
                checkmarkColor = Color.White
            ),
        )
    }
}
