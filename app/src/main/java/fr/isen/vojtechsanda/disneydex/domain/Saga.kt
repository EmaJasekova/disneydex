package fr.isen.vojtechsanda.disneydex.domain

data class Saga(
    val name: String,
    val genre: String,
    val movies: List<Movie>
)
