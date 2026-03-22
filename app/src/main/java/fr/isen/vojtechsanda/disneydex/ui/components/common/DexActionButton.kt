package fr.isen.vojtechsanda.disneydex.ui.components.common

import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp

@Composable
fun DexActionButton(
    onClick: () -> Unit,
    icon: ImageVector,
    tint: Color = Color.Unspecified,
    size: Dp,
    contentDescription: String,
    enabled: Boolean = true,
) {
    IconButton(onClick = onClick, enabled = enabled) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            tint = tint,
            modifier = Modifier
                .size(size)
                .alpha(if (enabled) 1f else 0.38f)
        )
    }
}
