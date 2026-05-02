package br.com.fiap.omni_tribo.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_mission")
data class Mission(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val tag: String,
    val title: String,
    val subtitle: String,
    val dist: String,
    val xp: Int,
    val brl: String,
    val time: String,
    val completed: Boolean = false,
)

val sampleMissions = listOf(
    Mission(1, "Entrega", "Cesta orgânica para vizinha", "Vila Madalena → Pinheiros · 320 m", "320 m", 240, "18", "25 min"),
    Mission(2, "Coleta", "Recolher recicláveis no bairro", "Rota com 5 paradas · começa às 14h", "1,2 km", 480, "32", "1 h 20"),
    Mission(3, "Tribo", "Mutirão de horta comunitária", "Praça do Pôr-do-Sol · sábado 10h", "2,4 km", 600, "—", "3 h"),
    Mission(4, "Entrega", "Pão fresco para idosos", "Padaria Estrela · 4 endereços", "480 m", 180, "12", "40 min"),
    Mission(5, "Ajuda", "Levar caixa de doações até o CRAS", "CRAS Pinheiros · R. Capote Valente", "900 m", 320, "22", "50 min"),
    Mission(6, "Entrega", "Remédios para dona Carmem", "Farmácia Drogal → R. Fidalga, 210", "650 m", 200, "15", "30 min"),
    Mission(7, "Tribo", "Pintura do muro da escola", "Escola Mun. Pinheiros · sábado 8h", "1,8 km", 750, "—", "4 h"),
    Mission(8, "Coleta", "Coleta de eletrônicos descartados", "Centro de Coleta · Av. Rebouças, 1005", "1,1 km", 420, "28", "1 h"),
    Mission(9, "Ajuda", "Cuidar do pet da vizinha por 2h", "R. João Moura, 580", "200 m", 150, "10", "2 h"),
)
