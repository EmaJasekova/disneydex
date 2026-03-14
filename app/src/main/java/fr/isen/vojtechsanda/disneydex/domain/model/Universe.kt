package fr.isen.vojtechsanda.disneydex.domain.model

import fr.isen.vojtechsanda.disneydex.domain.DEFAULT_POSTER_IMAGE

data class Universe(
    val id: String,
    val name: String,
    val sagas: List<Saga>,
    val description: String,
    val posterImages: List<String> = listOf(DEFAULT_POSTER_IMAGE, DEFAULT_POSTER_IMAGE, DEFAULT_POSTER_IMAGE)
)
