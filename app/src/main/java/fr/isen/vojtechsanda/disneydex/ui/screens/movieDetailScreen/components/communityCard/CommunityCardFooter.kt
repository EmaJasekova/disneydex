package fr.isen.vojtechsanda.disneydex.ui.screens.movieDetailScreen.components.communityCard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardDoubleArrowLeft
import androidx.compose.material.icons.filled.KeyboardDoubleArrowRight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import fr.isen.vojtechsanda.disneydex.ui.components.common.DexActionButton

@Composable
fun CommunityCardFooter(totalOffers: Int, viewModel: CommunityCardViewModel = viewModel()) {
    Row(
        Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        DexActionButton(
            tint = Color.LightGray,
            onClick = { viewModel.previousPage() },
            contentDescription = "Previous offers",
            icon = Icons.Default.KeyboardDoubleArrowLeft,
            size = 24.dp,
            enabled = viewModel.canGoBack(),
        )

        Text("Total offers: $totalOffers", fontSize = 14.sp, color = Color.LightGray)

        DexActionButton(
            tint = Color.LightGray,
            onClick = { viewModel.nextPage() },
            contentDescription = "Next offers",
            icon = Icons.Default.KeyboardDoubleArrowRight,
            size = 24.dp,
            enabled = viewModel.canGoNext(totalOffers),
        )
    }
}
