package fr.isen.vojtechsanda.disneydex.domain.model

/**
 * User profile stored in the database. Contains preferences and app-specific data.
 */
data class User(
    val uid: String,
    val email: String,
    val username: String
)
