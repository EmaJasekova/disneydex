package fr.isen.vojtechsanda.disneydex.ui.screens.universesScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import fr.isen.vojtechsanda.disneydex.domain.model.AuthUser
import fr.isen.vojtechsanda.disneydex.ui.components.layout.AuthedScaffold
import fr.isen.vojtechsanda.disneydex.ui.screens.universesScreen.components.UniverseCard

@Composable
fun UniversesScreen(navController: NavHostController) {
    AuthedScaffold(
        navController = navController,
        {
            Column(
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                val users = listOf(
                    AuthUser(id = "user-1", email = "test-1@idk.idk", username = "Tester 1"),
                    AuthUser(id = "user-2", email = "test-2@idk.idk", username = "Tester 2"),
                    AuthUser(id = "user-3", email = "test-3@idk.idk", username = "Tester 3"),
                    AuthUser(id = "user-4", email = "test-4@idk.idk", username = "Tester 4")
                )

                UniverseCard(
                    title = "Marvel Cinematic",
                    subtitle = "Phase 1 - Phase 5",
                    posterImages = listOf(
                        "https://shoptrends.com/pub/media/catalog/product/p/o/pod2228-1.jpg",
                        "https://m.media-amazon.com/images/I/71vkZeNX8jL._AC_UF894,1000_QL80_.jpg",
                        "https://lh5.googleusercontent.com/proxy/whJNlo-w4QVV9DV1LJklWYJ39FyYnEj547rB25XNrlzkJ4cnWuZgF4O3PqsWdQ5gfyD6Ja4g1eJn7JMYdppJNsmWbN1iboT3mApVFkz7",
                    ),
                    users
                )

                UniverseCard(
                    title = "Marvel Cinematic",
                    subtitle = "Phase 1 - Phase 5",
                    posterImages = listOf(
                        "https://shoptrends.com/pub/media/catalog/product/p/o/pod2228-1.jpg",
                        "https://m.media-amazon.com/images/I/71vkZeNX8jL._AC_UF894,1000_QL80_.jpg",
                        "https://lh5.googleusercontent.com/proxy/whJNlo-w4QVV9DV1LJklWYJ39FyYnEj547rB25XNrlzkJ4cnWuZgF4O3PqsWdQ5gfyD6Ja4g1eJn7JMYdppJNsmWbN1iboT3mApVFkz7",
                    ),
                    users
                )

                UniverseCard(
                    title = "Marvel Cinematic",
                    subtitle = "Phase 1 - Phase 5",
                    posterImages = listOf(
                        "https://shoptrends.com/pub/media/catalog/product/p/o/pod2228-1.jpg",
                        "https://m.media-amazon.com/images/I/71vkZeNX8jL._AC_UF894,1000_QL80_.jpg",
                        "https://lh5.googleusercontent.com/proxy/whJNlo-w4QVV9DV1LJklWYJ39FyYnEj547rB25XNrlzkJ4cnWuZgF4O3PqsWdQ5gfyD6Ja4g1eJn7JMYdppJNsmWbN1iboT3mApVFkz7",
                    ),
                    users
                )
            }
        }
    )
}
