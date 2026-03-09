package fr.isen.vojtechsanda.disneydex.dto

data class UniverseDto(
    val name: String = "",
    val sagas: List<SagaDto> = emptyList()
)
