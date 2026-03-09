package fr.isen.vojtechsanda.disneydex.dto

data class SagaDto(
    val name: String = "",
    val genre: String = "",
    val movies: List<MovieDto> = emptyList()
)
