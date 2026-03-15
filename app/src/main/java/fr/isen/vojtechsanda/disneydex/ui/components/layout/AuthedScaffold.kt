package fr.isen.vojtechsanda.disneydex.ui.components.layout

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import fr.isen.vojtechsanda.disneydex.R
import fr.isen.vojtechsanda.disneydex.routing.Route
import fr.isen.vojtechsanda.disneydex.ui.theme.AppBackgroundColor

val bottomNavigationItems = listOf(
    DexBottomNavigationBarItem(
        route = Route.Universes,
        title = "Universes",
        iconRes = R.drawable.outline_planet_24
    ),
    DexBottomNavigationBarItem(
        route = Route.Profile("TEST_USER_ID"),
        title = "Profile",
        iconRes = R.drawable.baseline_person_24
    )
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AuthedScaffold(
    navController: NavHostController,
    content: @Composable () -> Unit,
    hero: @Composable () -> Unit = {},
) {
    Scaffold(
        topBar = { DexTopAppBar() },
        bottomBar = {
            DexBottomNavigationBar(
                navController,
                bottomNavigationItems
            )
        },
        modifier = Modifier.fillMaxSize(),
        containerColor = AppBackgroundColor,
    ) { innerPadding ->
        val scrollState = rememberScrollState()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(scrollState)
        ) {
            hero()

            Column(
                Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                content()
            }
        }
    }
}
