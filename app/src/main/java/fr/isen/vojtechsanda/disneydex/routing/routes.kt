package fr.isen.vojtechsanda.disneydex.routing

import kotlinx.serialization.Serializable

@Serializable
object LoginRoute

@Serializable
object RegisterRoute

@Serializable
object UniversesRoute

@Serializable
data class UniverseOverviewRoute(val universeId: String)

@Serializable
data class MovieDetailRoute(val movieId: String)

@Serializable
data class ProfileRoute(val userId: String)
