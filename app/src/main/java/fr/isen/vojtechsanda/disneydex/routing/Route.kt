package fr.isen.vojtechsanda.disneydex.routing

import kotlinx.serialization.Serializable

@Serializable
sealed interface Route {
    @Serializable
    data object Login : Route

    @Serializable
    data object Register : Route

    @Serializable
    data object Universes : Route

    @Serializable
    data class UniverseOverview(val universeId: String) : Route

    @Serializable
    data class MovieDetail(val movieId: String) : Route

    @Serializable
    data class Profile(val userId: String) : Route
}
