package br.usp.esalq.caminhabilidade.presentation.journey

import androidx.compose.ui.graphics.vector.ImageVector

data class Dimension(
    val id: String,
    val name: String,
    val icon: ImageVector
)

data class Option(
    val id: String,
    val description: String,
    val dimensionId: String
)

data class JourneyUiState(
    val dimensions: Map<Dimension, List<Option>> = emptyMap(),
    val elapsedTime: String = "00:00:00"
)