package fr.isen.vojtechsanda.disneydex.routing

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import fr.isen.vojtechsanda.disneydex.screens.loginScreen.LoginScreen
import fr.isen.vojtechsanda.disneydex.screens.movieDetailScreen.MovieDetailScreen
import fr.isen.vojtechsanda.disneydex.screens.profileScreen.ProfileScreen
import fr.isen.vojtechsanda.disneydex.screens.registerScreen.RegisterScreen
import fr.isen.vojtechsanda.disneydex.screens.universeOverviewScreen.UniverseOverviewScreen
import fr.isen.vojtechsanda.disneydex.screens.universesScreen.UniversesScreen

@Composable
fun AppRouter() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = LoginRoute
    ) {
        composable<LoginRoute> {
            LoginScreen(navController)
        }

        composable<RegisterRoute> {
            RegisterScreen(navController)
        }

        composable<UniversesRoute> {
            UniversesScreen()
        }

        composable<UniverseOverviewRoute> { backStackEntry ->
            val args = backStackEntry.toRoute<UniverseOverviewRoute>()
            UniverseOverviewScreen(universeId = args.universeId)
        }

        composable<MovieDetailRoute> { backStackEntry ->
            val args = backStackEntry.toRoute<MovieDetailRoute>()
            MovieDetailScreen(movieId = args.movieId)
        }

        composable<ProfileRoute> { backStackEntry ->
            val args = backStackEntry.toRoute<ProfileRoute>()
            ProfileScreen(userId = args.userId)
        }
    }
}
