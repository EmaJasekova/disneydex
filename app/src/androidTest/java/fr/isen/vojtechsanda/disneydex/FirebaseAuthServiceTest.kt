package fr.isen.vojtechsanda.disneydex

import fr.isen.vojtechsanda.disneydex.domain.service.AuthService
import fr.isen.vojtechsanda.disneydex.infrastructure.firebase.auth.FirebaseAuthService
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.ext.junit.runners.AndroidJUnit4

/**
 * Runs against real Firebase - requires network and a configured Firebase project.
 */
@RunWith(AndroidJUnit4::class)
class FirebaseAuthServiceTest {

    private val authService: AuthService = FirebaseAuthService()

    @Test
    fun register_login_logout_flow() {
        runBlocking {
            val email = "test_${System.currentTimeMillis()}@disneydex.test"
            val password = "password123"
            val username = "TestUser"

            // Register
            val registerResult = authService.register(email, password, username)
            assertTrue("Registration should succeed", registerResult.isSuccess)
            assertEquals(username, registerResult.getOrNull()?.username)

            // Should be logged in
            val userAfterRegister = authService.getCurrentUser()
            assertNotNull(userAfterRegister)
            assertEquals(username, userAfterRegister?.username)
            assertEquals(email, userAfterRegister?.email)

            // Logout
            val logoutResult = authService.logout()
            assertTrue("Logout should succeed", logoutResult.isSuccess)

            // Should be logged out
            assertNull(authService.getCurrentUser())

            // Login again
            val loginResult = authService.login(email, password)
            assertTrue("Login should succeed", loginResult.isSuccess)
            assertEquals(username, loginResult.getOrNull()?.username)

            // Cleanup: logout so test user doesn't stay logged in
            authService.logout()
        }
    }
}
