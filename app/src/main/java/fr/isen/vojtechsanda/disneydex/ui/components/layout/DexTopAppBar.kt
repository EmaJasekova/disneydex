package fr.isen.vojtechsanda.disneydex.ui.components.layout

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import fr.isen.vojtechsanda.disneydex.ui.components.common.TextLogo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DexTopAppBar(modifier: Modifier = Modifier) {
    TopAppBar(
        title = { TextLogo() },
        modifier = modifier
    )
}
