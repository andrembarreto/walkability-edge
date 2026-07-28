package br.usp.esalq.caminhabilidade.presentation.journey

import androidx.compose.runtime.Composable

@Composable
fun JourneyMainRoute(
    viewModel: JourneyViewModel,
    onNavigateToFinish: () -> Unit
) {
    JourneyMainScreen(
        elapsedTime =  viewModel.elapsedTime,
        onStopJourney = {
            viewModel.stopJourney()
            onNavigateToFinish()
        }
    )
}