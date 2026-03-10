package fr.isen.vojtechsanda.disneydex.domain.model

data class Universe(
    val id: String,
    val name: String,
    val sagas: List<Saga>
)
