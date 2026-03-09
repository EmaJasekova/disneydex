package fr.isen.vojtechsanda.disneydex.data.dto

data class UniverseDto(
    val name: String = "",
    val sagas: List<SagaDto> = emptyList()
)
