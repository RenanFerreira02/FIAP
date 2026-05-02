package br.com.fiap.omni_tribo.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.omni_tribo.components.*
import br.com.fiap.omni_tribo.repository.MissionsRepository
import br.com.fiap.omni_tribo.repository.UserRepository
import br.com.fiap.omni_tribo.ui.theme.*

@Composable
fun MissionDetailScreen(
    missionId: Int = 1,
    navController: NavController,
) {
    val context = LocalContext.current
    val userRepository = remember { UserRepository(context) }
    val missionsRepository = remember { MissionsRepository(context) }
    val mission = remember { missionsRepository.getMissionById(missionId) }

    var alreadyDone by remember { mutableStateOf(mission?.completed == true) }

    Scaffold(
        topBar = { OmniTopBar(title = "Detalhes", onBack = { navController.popBackStack() }) },
        bottomBar = { OmniBottomNav(navController = navController) },
        containerColor = Paper,
    ) { paddingValues ->
        Column(modifier = Modifier.fillMaxSize().padding(paddingValues)) {
            Column(modifier = Modifier.weight(1f).verticalScroll(rememberScrollState())) {
                // Hero image
                Box(
                    modifier = Modifier.fillMaxWidth().height(180.dp).background(GreenLight),
                    contentAlignment = Alignment.Center,
                ) {
                    Text("IMG · capa da missão", color = Ink50, fontSize = 11.sp, fontFamily = androidx.compose.ui.text.font.FontFamily.Monospace, letterSpacing = 0.6.sp)
                    Box(
                        modifier = Modifier.align(Alignment.TopStart).padding(12.dp).background(Coral, RoundedCornerShape(10.dp)).padding(horizontal = 10.dp, vertical = 4.dp),
                    ) {
                        Text("${mission?.tag?.uppercase() ?: "ENTREGA"} · URGENTE", color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.Bold, letterSpacing = 0.6.sp)
                    }
                }

                // Title
                Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)) {
                    Text(mission?.title ?: "Entregar cesta orgânica para vizinha", color = Ink, fontSize = 20.sp, fontWeight = FontWeight.Bold, lineHeight = 25.sp)
                    Spacer(modifier = Modifier.height(4.dp))
                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                        Icon(Icons.Outlined.LocationOn, null, tint = Ink70, modifier = Modifier.size(14.dp))
                        Text(mission?.subtitle ?: "Vila Madalena → Pinheiros · 320 m", color = Ink70, fontSize = 12.sp)
                    }
                }

                // Reward strip
                Row(
                    modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp).padding(bottom = 14.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    listOf(
                        Triple("+ ${mission?.xp ?: 240}", "XP", Amber),
                        Triple(if (mission?.brl != null && mission.brl != "—") "R\$ ${mission.brl}" else "—", "Pago", GreenDark),
                        Triple(mission?.time ?: "25min", "Tempo", Ink),
                        Triple("4.9★", "Pedido", Ink),
                    ).forEach { (value, label, color) ->
                        Column(
                            modifier = Modifier.weight(1f).background(Color.White, RoundedCornerShape(12.dp)).border(1.dp, Line, RoundedCornerShape(12.dp)).padding(vertical = 10.dp, horizontal = 6.dp),
                            horizontalAlignment = Alignment.CenterHorizontally,
                        ) {
                            Text(value, color = color, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                            Text(label.uppercase(), color = Ink50, fontSize = 10.sp, letterSpacing = 0.4.sp, modifier = Modifier.padding(top = 2.dp))
                        }
                    }
                }

                // Requester
                Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                    Text("PEDIDO POR", color = Ink70, fontSize = 11.sp, fontWeight = FontWeight.Bold, letterSpacing = 0.6.sp, modifier = Modifier.padding(bottom = 8.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth().background(Color.White, RoundedCornerShape(14.dp)).border(1.dp, Line, RoundedCornerShape(14.dp)).padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(12.dp),
                    ) {
                        Box(modifier = Modifier.size(44.dp).background(GreenLight, CircleShape), contentAlignment = Alignment.Center) {
                            Text("MA", color = GreenDark, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                        }
                        Column(modifier = Modifier.weight(1f)) {
                            Text("Marina Albuquerque", color = Ink, fontSize = 14.sp, fontWeight = FontWeight.SemiBold)
                            Text("Tribo Vila Madalena · 4.9★ · 32 pedidos", color = Ink70, fontSize = 12.sp)
                        }
                        Box(modifier = Modifier.size(36.dp).background(GreenLight, CircleShape), contentAlignment = Alignment.Center) {
                            Icon(Icons.Outlined.Chat, null, tint = GreenPrimary, modifier = Modifier.size(18.dp))
                        }
                    }
                }

                Spacer(modifier = Modifier.height(14.dp))

                // Route timeline
                Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                    Text("ROTA", color = Ink70, fontSize = 11.sp, fontWeight = FontWeight.Bold, letterSpacing = 0.6.sp, modifier = Modifier.padding(bottom = 10.dp))
                    Column(modifier = Modifier.fillMaxWidth().background(Color.White, RoundedCornerShape(14.dp)).border(1.dp, Line, RoundedCornerShape(14.dp)).padding(14.dp)) {
                        val steps = listOf(
                            "Coletar na Padaria Estrela" to "R. Harmonia, 220 · 9 min",
                            "Verificar etiqueta da cesta" to "QR code do pedido",
                            "Entregar para Marina" to "R. Cardeal Arcoverde, 1480 · 14 min",
                        )
                        steps.forEachIndexed { i, (title, subtitle) ->
                            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                    Box(
                                        modifier = Modifier.padding(top = 2.dp).size(14.dp)
                                            .background(if (i == 0) GreenPrimary else Color.Transparent, CircleShape)
                                            .border(2.dp, if (i == 0) GreenPrimary else Line, CircleShape),
                                    )
                                    if (i < steps.size - 1) Box(modifier = Modifier.width(2.dp).height(32.dp).background(Line))
                                }
                                Column(modifier = Modifier.weight(1f).padding(bottom = if (i < steps.size - 1) 14.dp else 0.dp)) {
                                    Text(title, color = Ink, fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
                                    Text(subtitle, color = Ink70, fontSize = 12.sp)
                                }
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))
            }

            // Sticky CTA
            Row(
                modifier = Modifier.fillMaxWidth().background(Color.White).drawBehind {
                    drawLine(Line, Offset(0f, 0f), Offset(size.width, 0f), 1.dp.toPx())
                }.padding(14.dp),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .height(48.dp)
                        .background(if (alreadyDone) Ink50 else GreenPrimary, RoundedCornerShape(14.dp))
                        .clickable(enabled = !alreadyDone) {
                            if (mission != null) {
                                userRepository.completeMission(mission.xp, mission.brl)
                                missionsRepository.markCompleted(mission.id)
                                alreadyDone = true
                                navController.popBackStack()
                            }
                        },
                    contentAlignment = Alignment.Center,
                ) {
                    Text(
                        text = if (alreadyDone) "Missão concluída ✓" else "Aceitar missão · ${mission?.time ?: "25 min"}",
                        color = Color.White, fontSize = 15.sp, fontWeight = FontWeight.Bold,
                    )
                }
                Box(
                    modifier = Modifier.size(48.dp).background(Color.White, RoundedCornerShape(14.dp)).border(1.5.dp, Line, RoundedCornerShape(14.dp)),
                    contentAlignment = Alignment.Center,
                ) {
                    Icon(Icons.Outlined.StarBorder, null, tint = Ink70, modifier = Modifier.size(20.dp))
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 412, heightDp = 892)
@Composable
private fun MissionDetailPreview() {
    MissionDetailScreen(missionId = 1, navController = rememberNavController())
}
