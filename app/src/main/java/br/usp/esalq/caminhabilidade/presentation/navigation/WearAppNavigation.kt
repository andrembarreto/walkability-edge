package br.usp.esalq.caminhabilidade.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.wear.compose.material3.ScreenScaffold
import androidx.wear.compose.navigation.SwipeDismissableNavHost
import androidx.wear.compose.navigation.composable
import androidx.wear.compose.navigation.rememberSwipeDismissableNavController
import br.usp.esalq.caminhabilidade.presentation.home.HomeRoute
import br.usp.esalq.caminhabilidade.presentation.home.HomeScreen
import br.usp.esalq.caminhabilidade.presentation.journey.JourneyMainRoute
import br.usp.esalq.caminhabilidade.presentation.journey.JourneyMainScreen
import br.usp.esalq.caminhabilidade.presentation.journey.JourneyViewModel

@Composable
fun WearAppNavigation() {
    val navController = rememberSwipeDismissableNavController()
    val journeyViewModel = remember {
        JourneyViewModel()
    }

    SwipeDismissableNavHost(
        navController = navController,
        startDestination = "home"
    ) {
        composable("home") {
            HomeRoute(
                viewModel = journeyViewModel,
                onNavigateToJourney = {
                    navController.navigate("journeyMain")
                }
            )
        }
        composable("journeyMain") {
            JourneyMainRoute(
                viewModel = journeyViewModel,
                onNavigateToFinish = {
                    navController.navigate("journeyFinish")
                }
            )
        }
        composable("journeyFinish") {
            ScreenScaffold {}
        }
    }
}