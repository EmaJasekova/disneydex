package fr.isen.vojtechsanda.disneydex.ui.components.common

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import fr.isen.vojtechsanda.disneydex.ui.theme.DarkGray
import fr.isen.vojtechsanda.disneydex.ui.theme.PaperColor

@Composable
fun DexCard(
    modifier: Modifier = Modifier,
    padding: Dp = 16.dp,
    contentAlignment: Alignment = Alignment.TopStart,
    propagateMinConstraints: Boolean = false,
    content: @Composable BoxScope.() -> Unit,
) {
    Box(
        modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .background(PaperColor)
            .border(1.dp, DarkGray, shape = RoundedCornerShape(10.dp))
            .padding(padding),
        contentAlignment,
        propagateMinConstraints,
        content
    )
}
