package com.example.lab13.ui

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.Composable

enum class ScreenState { LOADING, CONTENT, ERROR }

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedContentScreen() {
    var state by remember { mutableStateOf(ScreenState.LOADING) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = { state = ScreenState.LOADING }) { Text("Cargando") }
            Button(onClick = { state = ScreenState.CONTENT }) { Text("Contenido") }
            Button(onClick = { state = ScreenState.ERROR }) { Text("Error") }
        }

        AnimatedContent(
            targetState = state,
            transitionSpec = {
                fadeIn(animationSpec = tween(300)) with fadeOut(animationSpec = tween(200))
            }
        ) { target ->
            when (target) {
                ScreenState.LOADING -> {
                    Text("Cargando... Por favor espera", modifier = Modifier.padding(top = 24.dp))
                }
                ScreenState.CONTENT -> {
                    Text("Contenido cargado correctamente", modifier = Modifier.padding(top = 24.dp))
                }
                ScreenState.ERROR -> {
                    Text("Ocurrió un error. Intenta de nuevo.", modifier = Modifier.padding(top = 24.dp))
                }
            }
        }
    }
}
