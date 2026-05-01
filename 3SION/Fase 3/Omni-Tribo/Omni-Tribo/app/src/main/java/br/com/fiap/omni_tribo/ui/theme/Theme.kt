package br.com.fiap.omni_tribo.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = GreenPrimary,
    onPrimary = Color.White,
    primaryContainer = GreenLight,
    onPrimaryContainer = GreenDark,
    secondary = Amber,
    onSecondary = Color.White,
    secondaryContainer = AmberLight,
    tertiary = Coral,
    onTertiary = Color.White,
    tertiaryContainer = CoralLight,
    background = Paper,
    onBackground = Ink,
    surface = Color.White,
    onSurface = Ink,
    surfaceVariant = GreenLight,
    onSurfaceVariant = Ink70,
    outline = Line,
)

@Composable
fun OmniTriboTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,
        content = content
    )
}
