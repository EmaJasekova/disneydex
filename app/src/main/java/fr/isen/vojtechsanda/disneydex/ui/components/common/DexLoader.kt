package fr.isen.vojtechsanda.disneydex.ui.components.common

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun <T> DexLoader(
    loadingState: T?,
    content: @Composable (T) -> Unit,
) {
    when (loadingState) {
        null -> Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }

        else -> content(loadingState)
    }
}
