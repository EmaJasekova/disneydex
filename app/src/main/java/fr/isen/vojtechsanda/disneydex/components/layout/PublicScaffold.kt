package fr.isen.vojtechsanda.disneydex.components.layout

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import fr.isen.vojtechsanda.disneydex.ui.theme.BackgroundColor

@Composable
fun PublicScaffold(
    content: @Composable (modifier: Modifier) -> Unit,
) {
    Scaffold(containerColor = BackgroundColor, modifier = Modifier.fillMaxSize()) { innerPadding ->
        content(
            Modifier.padding(
                bottom = innerPadding.calculateBottomPadding()
            )
        )
    }
}
