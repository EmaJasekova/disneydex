package fr.isen.vojtechsanda.disneydex.domain.model

data class AuthUser(
    val credential: AuthCredential,
    val username: String
    ) {
        val id: String get() = credential.uid
        val email: String get() = credential.email
    }
