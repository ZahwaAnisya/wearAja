package com.example.wearos.presentation.theme

import androidx.compose.runtime.Composable
import androidx.wear.compose.material.MaterialTheme
import androidx.wear.compose.material.Colors
import androidx.compose.ui.graphics.Color

// Definisi warna tema
private val WearColorPalette = Colors(
    primary = Color.Red,
    background = Color.Black,
    surface = Color.DarkGray,
    onPrimary = Color.White,
    onSurface = Color.LightGray
)

@Composable
fun WearOSTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = WearColorPalette,
        content = content
    )
}
