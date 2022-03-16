package com.hernandazevedo.composetutorial.theme

import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

val Yellow800 = Color(0xFFF29F05)
val Red300 = Color(0xFFEA6D7E)
val Neutral8 = Color(0xff121212)
val Neutral7 = Color(0xde000000)
val Neutral6 = Color(0x99000000)
val Neutral5 = Color(0x61000000)
val Neutral4 = Color(0x1f000000)
val Neutral3 = Color(0x1fffffff)
val Neutral2 = Color(0x61ffffff)
val Neutral1 = Color(0xbdffffff)
val Neutral0 = Color(0xffffffff)

private val crane_red = Color(0xFFE30425)
private val crane_white = Color.White
private val crane_purple_700 = Color(0xFF720D5D)
private val crane_purple_800 = Color(0xFF5D1049)
private val crane_purple_900 = Color(0xFF4E0D3A)

val LightColorsPalette = lightColors(
    primary = Red300,
    secondary = crane_red,
    surface = crane_purple_900,
    onSurface = crane_white,
    primaryVariant = crane_purple_700,
    background = Neutral0
)

val DarkColorsPalette = darkColors(
    primary = Neutral7,
    onPrimary = Color.White,
    primaryVariant = Neutral7,
    secondary = Yellow800,
    onSecondary = Color.White,
    error = Red300,
    onError = Color.Black,
    background = Neutral8,
    surface = Neutral0
)
