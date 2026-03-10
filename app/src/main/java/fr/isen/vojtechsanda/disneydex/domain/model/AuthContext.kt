package fr.isen.vojtechsanda.disneydex.domain.model

enum class AuthContext(val fallbackMessage: String) {
    LOGIN("Login failed. Please try again."),
    REGISTER("Registration failed. Please try again.")
}
