package fr.isen.vojtechsanda.disneydex.dto

data class SagaDto(
    val id: String = "",
    val name: String = "",
    val genre: String = "",
    val movies: List<MovieDto> = emptyList()
)
