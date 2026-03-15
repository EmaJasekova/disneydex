package fr.isen.vojtechsanda.disneydex.ui.screens.movieDetailScreen.components.communityCard

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import fr.isen.vojtechsanda.disneydex.domain.model.AuthUser
import fr.isen.vojtechsanda.disneydex.domain.model.Movie
import fr.isen.vojtechsanda.disneydex.ui.screens.movieDetailScreen.components.DetailContainer

@Composable
fun CommunityCard(movie: Movie) {

    val users = listOf(
        // TODO: Change to correct user model
        AuthUser(id = "user-1", email = "test-1@idk.idk", username = "Tester 1"),
        AuthUser(id = "user-2", email = "test-2@idk.idk", username = "Tester 2"),
        AuthUser(id = "user-3", email = "test-3@idk.idk", username = "Tester 3"),
    )

    DetailContainer(title = "Available from community") {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            if (users.size == 0) {
                Text(text = "There are no copies of this movie available.", color = Color.LightGray)
            }

            users.map { user -> CommunityUserCard(user, movie) }
        }
    }
}
