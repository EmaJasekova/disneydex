package fr.isen.vojtechsanda.disneydex.domain.model

import fr.isen.vojtechsanda.disneydex.domain.DEFAULT_POSTER_IMAGE

data class Saga(
    val id: String,
    val name: String,
    val movies: List<Movie>,
    val imageUrl: String = DEFAULT_POSTER_IMAGE
)
