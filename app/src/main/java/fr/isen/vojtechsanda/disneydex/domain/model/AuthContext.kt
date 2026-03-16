package fr.isen.vojtechsanda.disneydex.domain.model

// TODO(Low): AuthContext placement - consider moving to domain.exception or domain.auth for better cohesion.
enum class AuthContext(val fallbackMessage: String) {
    LOGIN("Login failed. Please try again later."),
    REGISTER("Registration failed. Please try again later."),
    LOGOUT("Logout failed. Please try again later.")
}
