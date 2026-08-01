package br.usp.esalq.caminhabilidade.presentation.journey

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForwardIos
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.QuestionMark
import androidx.compose.material.icons.filled.RemoveRoad
import androidx.compose.material.icons.filled.Shield
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.wear.compose.material3.AlertDialog
import androidx.wear.compose.material3.Icon
import androidx.wear.compose.material3.IconButton
import androidx.wear.compose.material3.MaterialTheme
import androidx.wear.compose.material3.ScreenScaffold
import androidx.wear.compose.material3.Text
import androidx.wear.compose.ui.tooling.preview.WearPreviewDevices
import androidx.wear.compose.ui.tooling.preview.WearPreviewFontScales

@Composable
fun JourneyMainScreen(
    elapsedTime: String,
    dimensions: Map<Dimension, List<Option>>,
    onStopJourney: () -> Unit,
) {
    ScreenScaffold { contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            HelpButton()
            DimensionSelector(
                dimensions = dimensions.keys.toList(),
                modifier = Modifier.fillMaxWidth()
            )
            StatusBar(
                elapsedTime = elapsedTime,
                onStopJourney = onStopJourney
            )
        }
    }
}

@Composable
private fun HelpButton() {
    IconButton(
        onClick = { /* TODO */ },
        modifier = Modifier
            .background(color = MaterialTheme.colorScheme.secondaryDim, shape = CircleShape)
            .padding(4.dp)
            .size(12.dp)
    ) {
        Icon(
            imageVector = Icons.Default.QuestionMark,
            contentDescription = "Ajuda"
        )
    }
}

@Composable
private fun DimensionSelector(
    dimensions: List<Dimension>,
    modifier: Modifier = Modifier
) {

    var currentIndex by remember { mutableIntStateOf(0) }

    Selector(
        currentDimension = dimensions[currentIndex],
        onPreviousClick = {
            currentIndex = if (currentIndex > 0) currentIndex - 1 else dimensions.lastIndex
        },
        onNextClick = {
            currentIndex = if (currentIndex < dimensions.lastIndex) currentIndex + 1 else 0
        },
        modifier = modifier
    )
}

@Composable
private fun Selector(
    currentDimension: Dimension,
    onPreviousClick: () -> Unit,
    onNextClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
    ) {
        IconButton(
            onClick = onPreviousClick,
            modifier = Modifier.width(20.dp)
        ) {
           Icon(
               imageVector = Icons.Default.ArrowBackIosNew,
               contentDescription = "Dimensão anterior"
           )
        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = currentDimension.name
            )

            Spacer(modifier = Modifier.height(8.dp))

            Icon(
                imageVector = currentDimension.icon,
                contentDescription = currentDimension.name,
                modifier = Modifier.size(30.dp)
            )
        }

        IconButton(
            onClick = onNextClick,
            modifier = Modifier.width(20.dp)
        ) {
            Icon(
                imageVector = Icons.AutoMirrored.Default.ArrowForwardIos,
                contentDescription = "Dimensão seguinte"
            )
        }
    }
}

@Composable
private fun StatusBar(
    elapsedTime: String,
    onStopJourney: () -> Unit
) {
    var showFinishDialog by remember { mutableStateOf(false) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Em percurso",
                fontSize = 12.sp
            )
            Spacer(modifier = Modifier.width(4.dp))
            IconButton(
                onClick = { showFinishDialog = true },
                modifier = Modifier.size(16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Pause,
                    contentDescription = "Pausar",
                )
            }
        }
        Text(
            text = elapsedTime,
            fontSize = 10.sp
        )
    }

    AlertDialog(
        visible = showFinishDialog,
        onDismissRequest = { showFinishDialog = false },
        title = { Text("") },
        text = { Text("Finalizar percurso?") },
        icon = {
            Icon(
                imageVector = Icons.Default.RemoveRoad,
                contentDescription = "Estrada X"
            )
        },
        dismissButton = {
            IconButton(onClick = { showFinishDialog = false }) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = ""
                )
            }
        },
        confirmButton = {
            IconButton(onClick = onStopJourney) {
                Icon(
                    imageVector = Icons.Default.Check,
                    contentDescription = ""
                )
            }
        },
    )
}

@WearPreviewDevices
@WearPreviewFontScales
@Composable
fun JourneyPreview() {
    JourneyMainScreen(
        elapsedTime = "00:10:00",
        dimensions = mapOf(Pair(
            Dimension("SAFETY", "Segurança", Icons.Default.Shield),
            listOf(Option("POLICING", "Policiamento", "SAFETY")))),
        onStopJourney = {}
    )
}