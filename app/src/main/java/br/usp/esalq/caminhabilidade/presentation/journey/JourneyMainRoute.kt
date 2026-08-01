package br.usp.esalq.caminhabilidade.presentation.journey

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue

@Composable
fun JourneyMainRoute(
    viewModel: JourneyViewModel,
    onNavigateToFinish: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    JourneyMainScreen(
        elapsedTime =  uiState.elapsedTime,
        dimensions = uiState.dimensions,
        onStopJourney = {
            viewModel.stopJourney()
            onNavigateToFinish()
        }
    )
}