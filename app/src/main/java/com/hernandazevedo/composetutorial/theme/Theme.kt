package com.hernandazevedo.composetutorial.theme
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun ComposeTutorialTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColorsPalette else LightColorsPalette
    MaterialTheme(
        colors = colors,
        typography = ThemeTypography,
        shapes = ThemeShapes,
        content = content
    )
}
