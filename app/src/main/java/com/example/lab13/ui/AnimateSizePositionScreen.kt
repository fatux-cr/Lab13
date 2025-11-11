package com.example.lab13.ui

import androidx.compose.animation.core.tween
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.composed
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.layout.layout
import androidx.compose.runtime.Composable
import androidx.compose.ui.draw.clipToBounds
import kotlin.math.roundToInt

@Composable
fun AnimateSizePositionScreen() {
    var expanded by remember { mutableStateOf(false) }

    val sizeDp by animateDpAsState(targetValue = if (expanded) 220.dp else 100.dp, animationSpec = tween(600))
    val offsetX by animateDpAsState(targetValue = if (expanded) 80.dp else 0.dp, animationSpec = tween(600))
    val offsetY by animateDpAsState(targetValue = if (expanded) 60.dp else 0.dp, animationSpec = tween(600))

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .clipToBounds(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Button(onClick = { expanded = !expanded }) {
            Text(if (expanded) "Reducir" else "Expandir y mover")
        }

        Box(modifier = Modifier
            .size(sizeDp)
            .offset(x = offsetX, y = offsetY)
            .background(Color(0xFFFF7043))
        )
    }
}
