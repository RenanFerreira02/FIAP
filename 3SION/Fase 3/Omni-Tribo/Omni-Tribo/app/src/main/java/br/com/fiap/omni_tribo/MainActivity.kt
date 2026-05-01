package br.com.fiap.omni_tribo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import br.com.fiap.omni_tribo.navigation.NavigationRoutes
import br.com.fiap.omni_tribo.ui.theme.OmniTriboTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            OmniTriboTheme {
                NavigationRoutes()
            }
        }
    }
}
