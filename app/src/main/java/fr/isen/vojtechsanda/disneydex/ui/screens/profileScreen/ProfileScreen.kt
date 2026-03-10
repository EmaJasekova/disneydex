package fr.isen.vojtechsanda.disneydex.ui.screens.profileScreen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import fr.isen.vojtechsanda.disneydex.ui.components.layout.AuthedScaffold

@Composable
fun ProfileScreen(navController: NavHostController, userId: String) {
    AuthedScaffold(
        navController = navController,
        content = {
            Text("This is profile for user with id $userId")
        }
    )
}
