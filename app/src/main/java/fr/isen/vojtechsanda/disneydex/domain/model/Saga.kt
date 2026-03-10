package fr.isen.vojtechsanda.disneydex.domain.model

data class Saga(
    val id: String,
    val name: String,
    val genre: String,
    val movies: List<Movie>
)
