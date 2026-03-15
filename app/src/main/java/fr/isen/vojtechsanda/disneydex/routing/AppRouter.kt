package fr.isen.vojtechsanda.disneydex.routing

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import fr.isen.vojtechsanda.disneydex.ui.screens.loginScreen.LoginScreen
import fr.isen.vojtechsanda.disneydex.ui.screens.movieDetailScreen.MovieDetailScreen
import fr.isen.vojtechsanda.disneydex.ui.screens.profileScreen.ProfileScreen
import fr.isen.vojtechsanda.disneydex.ui.screens.registerScreen.RegisterScreen
import fr.isen.vojtechsanda.disneydex.ui.screens.universeOverviewScreen.UniverseOverviewScreen
import fr.isen.vojtechsanda.disneydex.ui.screens.universesScreen.UniversesScreen

@Composable
fun AppRouter() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Route.UniverseOverview("AASD")
    ) {
        composable<Route.Login> {
            LoginScreen(navController)
        }

        composable<Route.Register> {
            RegisterScreen(navController)
        }

        composable<Route.Universes> {
            UniversesScreen(navController)
        }

        composable<Route.UniverseOverview> { backStackEntry ->
            val args = backStackEntry.toRoute<Route.UniverseOverview>()
            UniverseOverviewScreen(navController, universeId = args.universeId)
        }

        composable<Route.MovieDetail> { backStackEntry ->
            val args = backStackEntry.toRoute<Route.MovieDetail>()
            MovieDetailScreen(navController, movieId = args.movieId)
        }

        composable<Route.Profile> { backStackEntry ->
            val args = backStackEntry.toRoute<Route.Profile>()
            ProfileScreen(navController, userId = args.userId)
        }
    }
}
