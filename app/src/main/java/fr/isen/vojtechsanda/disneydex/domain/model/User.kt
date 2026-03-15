package fr.isen.vojtechsanda.disneydex.domain.model

/**
 * User profile, contains preferences and app-specific data.
 */
data class User(
    val uid: String,
    val email: String,
    val username: String
)
