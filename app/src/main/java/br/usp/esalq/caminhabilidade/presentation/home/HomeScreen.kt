package br.usp.esalq.caminhabilidade.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material3.Button
import androidx.wear.compose.material3.Icon
import androidx.wear.compose.material3.ScreenScaffold
import androidx.wear.compose.material3.Text
import androidx.wear.compose.ui.tooling.preview.WearPreviewDevices
import androidx.wear.compose.ui.tooling.preview.WearPreviewFontScales
import br.usp.esalq.caminhabilidade.presentation.journey.JourneyMainScreen

@Composable
fun HomeScreen(
    onStartButtonClicked: () -> Unit
) {
    ScreenScaffold() { contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "Bem vindo(a)",
            )
            Spacer(modifier = Modifier.height(12.dp))
            Button(
                onClick = onStartButtonClicked,
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Icon(
                        imageVector = Icons.Default.PlayArrow,
                        contentDescription = "Iniciar"
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Iniciar percurso"
                    )
                }
            }
        }
    }
}

@WearPreviewDevices
@WearPreviewFontScales
@Composable
fun HomePreview() {
    HomeScreen(onStartButtonClicked = {})
}