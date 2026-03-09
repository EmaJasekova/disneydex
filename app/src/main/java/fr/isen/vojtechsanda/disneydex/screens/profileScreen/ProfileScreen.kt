package fr.isen.vojtechsanda.disneydex.screens.profileScreen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import fr.isen.vojtechsanda.disneydex.components.layout.AuthedScaffold

@Composable
fun ProfileScreen(userId: String) {
    AuthedScaffold(
        content = {
            Text("This is profile for user with id $userId")
        }
    )
}
