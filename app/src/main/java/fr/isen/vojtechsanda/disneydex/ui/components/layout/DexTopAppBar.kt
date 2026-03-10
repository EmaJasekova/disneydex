package fr.isen.vojtechsanda.disneydex.ui.components.layout

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import fr.isen.vojtechsanda.disneydex.ui.components.common.TextLogo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DexTopAppBar() {
    TopAppBar(title = { TextLogo() })
}
