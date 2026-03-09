package fr.isen.vojtechsanda.disneydex.dto

data class UniverseDto(
    val id: String = "",
    val name: String = "",
    val sagas: List<SagaDto> = emptyList()
)
