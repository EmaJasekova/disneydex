package fr.isen.vojtechsanda.disneydex.domain

data class Universe(
    val id: String,
    val name: String,
    val sagas: List<Saga>
)
