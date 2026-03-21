package fr.isen.vojtechsanda.disneydex.ui.components.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import fr.isen.vojtechsanda.disneydex.ui.core.SnackbarController
import fr.isen.vojtechsanda.disneydex.ui.theme.AppBackgroundColor

@Composable
fun PublicScaffold(
    hero: @Composable () -> Unit = {},
    content: @Composable () -> Unit,
) {
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(Unit) {
        SnackbarController.events.collect { message ->
            snackbarHostState.showSnackbar(message)
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(snackbarHostState) },
        containerColor = AppBackgroundColor,
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        val scrollState = rememberScrollState()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
        ) {
            hero()

            Column(
                Modifier
                    .fillMaxSize()
                    .padding(
                        top = 0.dp,
                        bottom = innerPadding.calculateBottomPadding(),
                        start = 24.dp,
                        end = 24.dp,
                    )
            ) {
                content()
            }
        }
    }
}
