package fr.isen.vojtechsanda.disneydex.ui.screens.profileScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import fr.isen.vojtechsanda.disneydex.domain.model.Movie
import fr.isen.vojtechsanda.disneydex.ui.components.layout.AuthedScaffold
import fr.isen.vojtechsanda.disneydex.ui.screens.profileScreen.components.CollectionTitle
import fr.isen.vojtechsanda.disneydex.ui.screens.profileScreen.components.MovieCard
import fr.isen.vojtechsanda.disneydex.ui.screens.profileScreen.components.ProfileCard
import fr.isen.vojtechsanda.disneydex.ui.screens.profileScreen.components.SearchMovie
import java.time.LocalDate

@Composable
fun ProfileScreen(navController: NavHostController, userId: String) {

    var movies by remember {
        mutableStateOf(
            listOf(
                Movie(
                    id = "1",
                    name = "Thor: Love and Thunder",
                    releaseDate = LocalDate.of(2023, 5, 21)
                ),
                Movie(
                    id = "2",
                    name = "Iron Man",
                    releaseDate = LocalDate.of(2008, 5, 2)
                ),
                Movie(
                    id = "3",
                    name = "Black Panther",
                    releaseDate = LocalDate.of(2018, 2, 16)
                ),
                Movie(
                    id = "4",
                    name = "The Cats",
                    releaseDate = LocalDate.of(2016, 7, 22)
                ),
            )
        )
    }

    AuthedScaffold(navController = navController, hero = {}, content = {
        ProfileCard(
            url = "https://api.dicebear.com/9.x/lorelei/png?seed=1",
            username = "Alex Mercer",
            email = "alex.mercer@example.com",
            dateJoined = LocalDate.of(2023, 5, 21)
        )
        Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
            CollectionTitle()
            SearchMovie()
            movies.forEach { movie ->
                MovieCard(
                    movie = movie,
                    // TODO: Add poster property in the Movie model
                    poster = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSsfq5js5aFiTSUW-apcciHfsOfb3XKy67IgA&s",
                    onDelete = { movies = movies.filter { it.id != movie.id } })
            }
        }
    })
}
