package fr.isen.vojtechsanda.disneydex.ui.screens.profileScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import fr.isen.vojtechsanda.disneydex.domain.model.AuthUser
import fr.isen.vojtechsanda.disneydex.domain.model.Movie
import fr.isen.vojtechsanda.disneydex.ui.components.common.MovieCard
import fr.isen.vojtechsanda.disneydex.ui.components.layout.AuthedScaffold
import fr.isen.vojtechsanda.disneydex.ui.screens.profileScreen.components.CollectionTitle
import fr.isen.vojtechsanda.disneydex.ui.screens.profileScreen.components.ProfileCard
import fr.isen.vojtechsanda.disneydex.ui.screens.profileScreen.components.SearchMovie
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
                    releaseDate = mockYear(2020),
                    studio = "Marvel Studios",
                    posterImage = "https://m.media-amazon.com/images/M/MV5BZjRiMDhiZjQtNjk5Yi00ZDcwLTkyYTEtMDc1NjdmNjFhNGIzXkEyXkFqcGc@._V1_.jpg"
                ),
                Movie(
                    id = "2",
                    name = "Iron Man",
                    genre = "Action",
                    duration = 126,
                    releaseDate = mockYear(2015),
                    studio = "Marvel Studios",
                    posterImage = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT9oRfUjbqBdsh61eWZrUlu8X-eDrcCehIvrw&s"
                ),
                Movie(
                    id = "3",
                    name = "Black Panther",
                    genre = "Action",
                    duration = 134,
                    releaseDate = mockYear(2018),
                    studio = "Marvel Studios",
                    posterImage = "https://m.media-amazon.com/images/M/MV5BMTg1MTY2MjYzNV5BMl5BanBnXkFtZTgwMTc4NTMwNDI@._V1_.jpg"
                ),
                Movie(
                    id = "4",
                    name = "The Cats",
                    genre = "Comedy",
                    duration = 110,
                    releaseDate = mockYear(2018),
                    studio = "Universal Pictures",
                    posterImage = "https://i.etsystatic.com/57313645/r/il/fdb8ee/6643013613/il_fullxfull.6643013613_sb80.jpg"
                )
            )
        )
    }

    val user = AuthUser(id = userId, username = "Alex Mercer", email = "alex.mercer@example.com")

    AuthedScaffold(navController = navController, content = {
        ProfileCard(user, modifier = Modifier.padding(top = 8.dp, bottom = 24.dp))

        Spacer(
            Modifier
                .height(1.dp)
                .background(Color.LightGray)
                .fillMaxWidth()
        )

        Spacer(Modifier.height(28.dp))

        Column(verticalArrangement = Arrangement.spacedBy(20.dp)) {
            CollectionTitle()
            SearchMovie()

            movies.forEach { movie ->
                MovieCard(
                    movie = movie,
                    onDelete = { movies = movies.filter { it.id != movie.id } })
            }
        }
    })
}
