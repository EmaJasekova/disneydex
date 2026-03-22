package fr.isen.vojtechsanda.disneydex.domain.auth

enum class AuthContext(val fallbackMessage: String) {
    LOGIN("Login failed. Please try again later."),
    REGISTER("Registration failed. Please try again later."),
    LOGOUT("Logout failed. Please try again later.")
}
