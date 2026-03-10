package fr.isen.vojtechsanda.disneydex.ui.screens.loginScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import fr.isen.vojtechsanda.disneydex.ui.components.authentication.AuthenticationBody
import fr.isen.vojtechsanda.disneydex.ui.components.authentication.AuthenticationHero
import fr.isen.vojtechsanda.disneydex.ui.components.authentication.AuthenticationTitle
import fr.isen.vojtechsanda.disneydex.ui.components.layout.PublicScaffold
import fr.isen.vojtechsanda.disneydex.routing.RegisterRoute
import fr.isen.vojtechsanda.disneydex.routing.UniversesRoute
import fr.isen.vojtechsanda.disneydex.ui.screens.loginScreen.components.LoginForm

@Composable
fun LoginScreen(navController: NavHostController) {
    PublicScaffold { modifier ->
        Column(modifier) {
            AuthenticationHero(Modifier.weight(1.4f))

            AuthenticationBody(Modifier.weight(2.6f)) {
                AuthenticationTitle(
                    title = "Welcome back!",
                    subtitle = "Continue your journey in the Multiverse!"
                )

                LoginForm(
                    onLogin = {
                        navController.navigate(UniversesRoute) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                inclusive = true
                            }
                        }
                    }
                )

                Spacer(modifier = Modifier.height(8.dp))

                TextButton(onClick = { navController.navigate(RegisterRoute) }) {
                    Text("I don't have any account. Register.", color = Color.LightGray)
                }
            }
        }
    }
}
