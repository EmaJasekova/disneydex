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
import fr.isen.vojtechsanda.disneydex.ui.components.form.DexAutocomplete
import fr.isen.vojtechsanda.disneydex.ui.components.common.MovieCard
import fr.isen.vojtechsanda.disneydex.ui.components.layout.AuthedScaffold
import fr.isen.vojtechsanda.disneydex.ui.screens.profileScreen.components.CollectionTitle
import fr.isen.vojtechsanda.disneydex.ui.screens.profileScreen.components.ProfileCard
import java.time.LocalDate

@Composable
fun ProfileScreen(navController: NavHostController, userId: String) {
    fun mockYear(year: Int) = LocalDate.of(year, 1, 1)
    var movies by remember {
        mutableStateOf(
            listOf(
                Movie(
                    id = "1",
                    name = "Thor: Love and Thunder",
                    genre = "Action",
                    duration = 119,
                    releaseDate = mockYear(2022),
                    studio = "Marvel Studios",
                    posterImage = "https://image.tmdb.org/t/p/w500/pIkRyD18kl4FhoCNQuWxWu5cBLM.jpg"
                ),
                Movie(
                    id = "2",
                    name = "Iron Man",
                    genre = "Action",
                    duration = 126,
                    releaseDate = mockYear(2008),
                    studio = "Marvel Studios",
                    posterImage = "https://image.tmdb.org/t/p/w500/cyecB7godJ6kNHGONFjUyVN9OX5.jpg"
                ),
                Movie(
                    id = "3",
                    name = "Black Panther",
                    genre = "Action",
                    duration = 134,
                    releaseDate = mockYear(2018),
                    studio = "Marvel Studios",
                    posterImage = "https://image.tmdb.org/t/p/w500/uxzzxijgPIY7slzFvMotPv8wjKA.jpg"
                ),
                Movie(
                    id = "4",
                    name = "Cats",
                    genre = "Comedy",
                    duration = 110,
                    releaseDate = mockYear(2019),
                    studio = "Universal Pictures",
                    posterImage = "https://image.tmdb.org/t/p/w500/vedB4lMoMH6bYLXAHeRGDGBqQke.jpg"
                )
            )
        )
    }

    AuthedScaffold(navController = navController, hero = {}, content = {
        ProfileCard(
            url = "https://api.dicebear.com/9.x/lorelei/png?seed=1",
            username = "Alex Mercer",
            email = "alex.mercer@example.com",
            dateJoined = mockYear(2026)
        )
        
        Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
            CollectionTitle()
            DexAutocomplete()
            movies.forEach { movie ->
                MovieCard(
                    movie = movie,
                    onDelete = { movies = movies.filter { it.id != movie.id } })
            }
        }
    })
}