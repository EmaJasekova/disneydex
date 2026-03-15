package fr.isen.vojtechsanda.disneydex.domain.model

import fr.isen.vojtechsanda.disneydex.domain.AVATAR_BASE_URL

/**
 * User profile, contains app-specific data.
 */
data class User(
    val uid: String,
    val email: String,
    val username: String,
    val avatarPath: String = generateAvatarUrl(uid),
    val createdAt: Long = System.currentTimeMillis(),

    val watchedIds: List<String> = emptyList(),
    val watchlistIds: List<String> = emptyList(),
    val ownedIds: List<String> = emptyList(),
    val forTradeIds: List<String> = emptyList()
) {
    companion object {
        fun generateAvatarUrl(uid: String): String = "$AVATAR_BASE_URL?seed=$uid"
    }
}
