package com.example.lab13.ui

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

enum class AppMode { LIGHT, DARK }

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun CombinedAnimationsScreen() {

    var big by remember { mutableStateOf(false) }
    var showButton by remember { mutableStateOf(true) }
    var mode by remember { mutableStateOf(AppMode.LIGHT) }

    // Animación del tamaño
    val size by animateDpAsState(
        targetValue = if (big) 220.dp else 120.dp,
        animationSpec = tween(durationMillis = 500)
    )

    // Animación del color
    val color by animateColorAsState(
        targetValue = if (big) Color(0xFFEF5350) else Color(0xFF29B6F6),
        animationSpec = tween(durationMillis = 500)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(18.dp)
    ) {
        // Elemento que cambia tamaño y color
        Box(
            modifier = Modifier
                .size(size)
                .background(color)
        )

        // Alterna la animación de tamaño/color
        Button(onClick = { big = !big }) {
            Text(if (big) "Reducir" else "Expandir y cambiar color")
        }

        // Desplaza y desaparece con animación
        AnimatedVisibility(
            visible = showButton,
            enter = slideInHorizontally(animationSpec = tween(400)) + fadeIn(),
            exit = slideOutHorizontally(targetOffsetX = { fullWidth -> fullWidth }) + fadeOut()
        ) {
            Button(onClick = { showButton = false }) {
                Text("Desaparecer")
            }
        }

        // Switch de modo
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = { mode = AppMode.LIGHT }) { Text("Modo claro") }
            Button(onClick = { mode = AppMode.DARK }) { Text("Modo oscuro") }
        }

        // AnimatedContent
        AnimatedContent(
            targetState = mode,
            transitionSpec = {
                fadeIn(animationSpec = tween(300)) togetherWith fadeOut(animationSpec = tween(200))
            }
        ) { m ->
            when (m) {
                AppMode.LIGHT -> Text("Pantalla en modo claro")
                AppMode.DARK -> Text("Pantalla en modo oscuro")
            }
        }
    }
}
