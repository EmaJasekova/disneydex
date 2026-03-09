package fr.isen.vojtechsanda.disneydex.domain

data class Saga(
    val id: String,
    val name: String,
    val genre: String,
    val movies: List<Movie>
)
