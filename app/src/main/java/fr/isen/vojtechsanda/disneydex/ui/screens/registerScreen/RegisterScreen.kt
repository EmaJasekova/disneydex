package fr.isen.vojtechsanda.disneydex.ui.screens.registerScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import fr.isen.vojtechsanda.disneydex.routing.Route
import fr.isen.vojtechsanda.disneydex.ui.components.authentication.AuthenticationBody
import fr.isen.vojtechsanda.disneydex.ui.components.authentication.AuthenticationHero
import fr.isen.vojtechsanda.disneydex.ui.components.authentication.AuthenticationTitle
import fr.isen.vojtechsanda.disneydex.ui.components.layout.PublicScaffold
import fr.isen.vojtechsanda.disneydex.ui.screens.registerScreen.components.RegisterForm

@Composable
fun RegisterScreen(navController: NavHostController) {
    PublicScaffold(
        hero = { AuthenticationHero(Modifier.height(300.dp)) },
        content = {
            Column(Modifier.fillMaxSize()) {
                AuthenticationBody {
                    AuthenticationTitle(
                        title = "Create an account",
                        subtitle = "Register and join the Multiverse!"
                    )

                    RegisterForm(
                        onRegister = { navController.navigate(Route.Login) }
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    TextButton(onClick = { navController.navigate(Route.Login) }) {
                        Text("I already have an account. Log In.", color = Color.LightGray)
                    }
                }
            }
        })
}
