package com.example.a20230715_joshgebbeken_nycschools.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Shapes

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable


private val LightColorScheme = lightColorScheme(
    primary = LightPrimary,
    onPrimary = DarkPrimary,
    secondary = LightSecondary,
    onSecondary = DarkSecondary
)

private val DarkColorScheme = darkColorScheme(
    primary = DarkPrimary,
    onPrimary = LightPrimary,
    secondary = DarkSecondary,
    onSecondary = LightSecondary
)

@Composable
fun SchoolTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {
    MaterialTheme(
        colorScheme = if (darkTheme) LightColorScheme else DarkColorScheme,
        typography = Typography,
        shapes = Shapes(),
        content = content
    )
}
