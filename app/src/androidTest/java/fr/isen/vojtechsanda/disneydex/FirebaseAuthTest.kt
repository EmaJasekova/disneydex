package fr.isen.vojtechsanda.disneydex

import fr.isen.vojtechsanda.disneydex.domain.usecase.auth.GetCurrentUserUseCase
import fr.isen.vojtechsanda.disneydex.domain.usecase.auth.LoginUseCase
import fr.isen.vojtechsanda.disneydex.domain.usecase.auth.LogoutUseCase
import fr.isen.vojtechsanda.disneydex.domain.usecase.auth.RegisterUseCase
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
class FirebaseAuthTest {

    private val registerUseCase: RegisterUseCase = AppContainer.registerUseCase
    private val loginUseCase: LoginUseCase = AppContainer.loginUseCase
    private val logoutUseCase: LogoutUseCase = AppContainer.logoutUseCase
    private val getCurrentUserUseCase: GetCurrentUserUseCase = AppContainer.getCurrentUserUseCase

    @Test
    fun register_login_logout_flow() {
        runBlocking {
            val email = "test_${System.currentTimeMillis()}@disneydex.test"
            val password = "password123"
            val username = "TestUser"

            // Register
            val registerResult = registerUseCase(email, password, username)
            assertTrue("Registration should succeed", registerResult.isSuccess)
            assertEquals(username, registerResult.getOrNull()?.username)

            // Should be logged in
            val userAfterRegister = getCurrentUserUseCase()
            assertNotNull(userAfterRegister)
            assertEquals(username, userAfterRegister?.username)
            assertEquals(email, userAfterRegister?.email)

            // Logout
            val logoutResult = logoutUseCase()
            assertTrue("Logout should succeed", logoutResult.isSuccess)

            // Should be logged out
            assertNull(getCurrentUserUseCase())

            // Login again
            val loginResult = loginUseCase(email, password)
            assertTrue("Login should succeed", loginResult.isSuccess)
            assertEquals(username, loginResult.getOrNull()?.username)

            // Cleanup: logout so test user doesn't stay logged in
            logoutUseCase()
        }
    }
}
