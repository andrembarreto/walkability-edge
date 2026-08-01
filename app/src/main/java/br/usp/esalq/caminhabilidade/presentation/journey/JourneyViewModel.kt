package br.usp.esalq.caminhabilidade.presentation.journey

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LinearScale
import androidx.compose.material.icons.filled.LocalConvenienceStore
import androidx.compose.material.icons.filled.SentimentVerySatisfied
import androidx.compose.material.icons.filled.Shield
import androidx.lifecycle.ViewModel
import br.usp.esalq.caminhabilidade.domain.journey.model.DimensionType
import br.usp.esalq.caminhabilidade.domain.journey.model.EventType
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class JourneyViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(JourneyUiState())
    val uiState: StateFlow<JourneyUiState> = _uiState.asStateFlow()

    init {
        loadData()
    }

    private fun loadData() {
        val dimensions = listOf(
            Dimension(DimensionType.SAFETY.name, "Segurança", Icons.Default.Shield),
            Dimension(DimensionType.CONTINUITY.name, "Continuidade", Icons.Default.LinearScale),
            Dimension(DimensionType.CONVENIENCE.name, "Conveniência", Icons.Default.LocalConvenienceStore),
            Dimension(DimensionType.PLEASANTNESS.name, "Agradabilidade", Icons.Default.SentimentVerySatisfied)
        )

        val options = listOf(
            Option(EventType.FELT_UNSAFE.name, "Desviei meu percurso por sentir insegurança",
                DimensionType.SAFETY.name)
        )

        val groupedData = dimensions.associateWith {
            dimension -> options.filter { it.dimensionId == dimension.id }
        }

        _uiState.update {
            it.copy(
                dimensions = groupedData,
                elapsedTime = "00:00:00"
            )
        }
    }

    fun startJourney() {

    }

    fun stopJourney() {

    }
}