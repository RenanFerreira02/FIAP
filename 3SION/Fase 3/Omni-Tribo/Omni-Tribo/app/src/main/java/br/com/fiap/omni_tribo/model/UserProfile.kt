package br.com.fiap.omni_tribo.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_user_profile")
data class UserProfile(
    @PrimaryKey
    val id: Int = 1,
    val name: String = "Renata Moraes",
    val handle: String = "@renatamo",
    val tribe: String = "Tribo Pinheiros",
    val xp: Int = 4820,
    val level: Int = 8,
    val xpThreshold: Int = 6000,
    val streak: Int = 7,
    val brl: Double = 142.50,
    val tokens: Int = 14,
    val missionsCompleted: Int = 52,
    val rating: Float = 4.8f,
    val tribeMembers: Int = 128,
)
