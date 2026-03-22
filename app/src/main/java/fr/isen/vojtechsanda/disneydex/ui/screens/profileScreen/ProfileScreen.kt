package fr.isen.vojtechsanda.disneydex.ui.screens.profileScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import fr.isen.vojtechsanda.disneydex.domain.model.Movie
import fr.isen.vojtechsanda.disneydex.ui.components.common.DexLoader
import fr.isen.vojtechsanda.disneydex.ui.components.common.MovieCard
import fr.isen.vojtechsanda.disneydex.ui.components.layout.AuthedScaffold
import fr.isen.vojtechsanda.disneydex.ui.screens.profileScreen.components.CollectionTitle
import fr.isen.vojtechsanda.disneydex.ui.screens.profileScreen.components.ProfileInfo
import fr.isen.vojtechsanda.disneydex.ui.screens.profileScreen.components.moviesAutocomplete.MoviesAutocomplete
import java.time.LocalDate

@Composable
fun ProfileScreen(navController: NavHostController, viewModel: ProfileViewModel = viewModel()) {
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
                    imageUrl = "https://image.tmdb.org/t/p/w500/pIkRyD18kl4FhoCNQuWxWu5cBLM.jpg"
                ),
                Movie(
                    id = "2",
                    name = "Iron Man",
                    genre = "Action",
                    duration = 126,
                    releaseDate = mockYear(2008),
                    studio = "Marvel Studios",
                    imageUrl = "https://image.tmdb.org/t/p/w500/cyecB7godJ6kNHGONFjUyVN9OX5.jpg"
                ),
                Movie(
                    id = "3",
                    name = "Black Panther",
                    genre = "Action",
                    duration = 134,
                    releaseDate = mockYear(2018),
                    studio = "Marvel Studios",
                    imageUrl = "https://image.tmdb.org/t/p/w500/uxzzxijgPIY7slzFvMotPv8wjKA.jpg"
                ),
                Movie(
                    id = "4",
                    name = "Cats",
                    genre = "Comedy",
                    duration = 110,
                    releaseDate = mockYear(2019),
                    studio = "Universal Pictures",
                    imageUrl = "https://image.tmdb.org/t/p/w500/vedB4lMoMH6bYLXAHeRGDGBqQke.jpg"
                )
            )
        )
    }

    val ownedMoviesState by viewModel.ownedMovies.collectAsState()
    val currentUserState by viewModel.currentUser.collectAsState()

    AuthedScaffold(
        navController = navController,
        disableScaffoldScrolling = true
    ) { innerPadding ->
        DexLoader(ownedMoviesState) { ownedMovies ->
            DexLoader(currentUserState) { currentUser ->
                LazyColumn(contentPadding = innerPadding) {
                    item { ProfileInfo(currentUser) }

                    item {
                        Spacer(
                            Modifier
                                .height(1.dp)
                                .background(Color.Gray)
                                .fillMaxWidth()
                        )
                    }

                    item { Spacer(Modifier.height(28.dp)) }

                    item { CollectionTitle() }

                    item { Spacer(Modifier.height(20.dp)) }

                    item {
                        MoviesAutocomplete(
                            label = "Add Movie to Collection",
                            placeholder = "Search by title...",
                            onSelected = { movie -> viewModel.addToOwned(movie) }
                        )
                    }

                    item { Spacer(Modifier.height(20.dp)) }

                    itemsIndexed(
                        items = ownedMovies,
                        key = { _, movie -> movie.id }
                    ) { index, movie ->
                        MovieCard(
                            movie = movie,
                            onDelete = { viewModel.removeFromOwned(movie) }
                        )

                        if (index < ownedMovies.size - 1)
                            Spacer(Modifier.height(20.dp))
                    }

                    if (ownedMovies.isEmpty()) {
                        item { Spacer(Modifier.height(20.dp)) }

                        item {
                            Text(
                                "There are no movies in your collection",
                                color = Color.LightGray,
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center
                            )
                        }
                    }
                }
            }
        }
    }
}
