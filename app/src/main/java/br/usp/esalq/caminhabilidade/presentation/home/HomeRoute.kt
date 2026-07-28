package br.usp.esalq.caminhabilidade.presentation.home

import androidx.compose.runtime.Composable
import br.usp.esalq.caminhabilidade.presentation.journey.JourneyViewModel

@Composable
fun HomeRoute(
    viewModel: JourneyViewModel,
    onNavigateToJourney: () -> Unit
) {
    HomeScreen(
        onStartButtonClicked = {
            viewModel.startJourney()
            onNavigateToJourney()
        }
    )
}