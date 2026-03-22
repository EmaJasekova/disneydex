package fr.isen.vojtechsanda.disneydex.ui.components.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
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
    disableScaffoldScrolling: Boolean = false,
    hero: @Composable () -> Unit = {},
    content: @Composable (innerPadding: PaddingValues) -> Unit,
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
        val scrollingModifier =
            if (disableScaffoldScrolling) Modifier else Modifier.verticalScroll(scrollState)

        Column(
            modifier = Modifier
                .fillMaxSize()
                .then(scrollingModifier)
        ) {
            hero()

            content(
                PaddingValues(
                    top = 0.dp,
                    bottom = innerPadding.calculateBottomPadding(),
                    start = 24.dp,
                    end = 24.dp,
                )
            )
        }
    }
}
