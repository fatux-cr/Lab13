package com.example.lab13.ui

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.Composable

@Composable
fun AnimateColorScreen() {
    var toggled by remember { mutableStateOf(false) }

    val targetColor by animateColorAsState(
        targetValue = if (toggled) Color(0xFF43A047) else Color(0xFF1E88E5),
        animationSpec = tween(durationMillis = 700)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Button(onClick = { toggled = !toggled }) {
            Text("Cambiar color")
        }

        Box(
            modifier = Modifier
                .size(180.dp)
                .background(targetColor)
        )
    }
}
