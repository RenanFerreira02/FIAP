package br.com.fiap.omni_tribo.repository

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import br.com.fiap.omni_tribo.model.Mission
import br.com.fiap.omni_tribo.model.sampleMissions

@Composable
fun getAllMissions(): List<Mission> {
    val missions by remember { mutableStateOf(sampleMissions) }
    return missions
}

fun getMissionById(id: Int): Mission? = sampleMissions.find { it.id == id }
