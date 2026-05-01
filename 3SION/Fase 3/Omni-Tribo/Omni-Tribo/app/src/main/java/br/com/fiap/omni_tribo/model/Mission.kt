package br.com.fiap.omni_tribo.model

data class Mission(
    val id: Int,
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
)
