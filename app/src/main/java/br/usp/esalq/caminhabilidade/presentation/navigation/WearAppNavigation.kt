package br.usp.esalq.caminhabilidade.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.wear.compose.navigation.SwipeDismissableNavHost
import androidx.wear.compose.navigation.composable
import androidx.wear.compose.navigation.rememberSwipeDismissableNavController
import br.usp.esalq.caminhabilidade.presentation.home.HomeScreen
import br.usp.esalq.caminhabilidade.presentation.views.JourneyMainScreen

@Composable
fun WearAppNavigation() {
    val navController = rememberSwipeDismissableNavController()

    SwipeDismissableNavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeScreen(
                onStart = { navController.navigate("journeyMain") }
            )
        }
        composable("journeyMain") {
            JourneyMainScreen()
        }
    }
}