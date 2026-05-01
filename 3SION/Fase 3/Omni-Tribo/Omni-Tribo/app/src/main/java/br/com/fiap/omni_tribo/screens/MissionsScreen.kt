package br.com.fiap.omni_tribo.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.omni_tribo.components.*
import br.com.fiap.omni_tribo.model.Mission
import br.com.fiap.omni_tribo.navigation.Destination
import br.com.fiap.omni_tribo.repository.getAllMissions
import br.com.fiap.omni_tribo.ui.theme.*

@Composable
fun MissionsScreen(
    navController: NavController,
    onMissionClick: (Int) -> Unit = {},
) {
    val missions = getAllMissions()
    val available = missions.filter { !it.completed }
    val completed = missions.filter { it.completed }
    val tabs = listOf("Disponíveis · ${available.size}", "Em andamento · 2", "Concluídas · ${completed.size}")

    Scaffold(
        topBar = { OmniTopBar(title = "Missões") },
        bottomBar = { OmniBottomNav(navController = navController) },
        floatingActionButton = { OmniFab(onClick = { navController.navigate(Destination.CreateMissionScreen.createRoute(1)) }) },
        containerColor = Paper,
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White)
                    .padding(horizontal = 12.dp),
            ) {
                tabs.forEachIndexed { i, tab ->
                    val active = i == 0
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .padding(vertical = 10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        Text(
                            text = tab,
                            color = if (active) GreenPrimary else Ink50,
                            fontSize = 12.sp,
                            fontWeight = if (active) FontWeight.Bold else FontWeight.Normal,
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(2.dp)
                                .background(if (active) GreenPrimary else Color.Transparent),
                        )
                    }
                }
            }
            HorizontalDivider(color = Line)

            LazyColumn(contentPadding = PaddingValues(bottom = 16.dp)) {
                item {
                    Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 14.dp)) {
                        Text(
                            "DESTAQUE DA SEMANA",
                            color = Ink70, fontSize = 11.sp, fontWeight = FontWeight.Bold,
                            letterSpacing = 0.6.sp, modifier = Modifier.padding(bottom = 8.dp),
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(GreenDark, RoundedCornerShape(16.dp))
                                .padding(14.dp),
                            horizontalArrangement = Arrangement.spacedBy(12.dp),
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text("BÔNUS 2× XP", color = Color.White.copy(alpha = 0.7f), fontSize = 11.sp, fontWeight = FontWeight.Bold, letterSpacing = 0.6.sp)
                                Spacer(modifier = Modifier.height(4.dp))
                                Text("Acompanhe a Tribo Pinheiros nesse fim de semana", color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.SemiBold, lineHeight = 21.sp)
                                Spacer(modifier = Modifier.height(8.dp))
                                Box(modifier = Modifier.background(Coral, RoundedCornerShape(10.dp)).padding(horizontal = 12.dp, vertical = 6.dp)) {
                                    Text("Ver evento →", color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                                }
                            }
                            Box(
                                modifier = Modifier.size(64.dp).background(Color.White.copy(alpha = 0.12f), RoundedCornerShape(12.dp)),
                                contentAlignment = Alignment.Center,
                            ) {
                                Icon(Icons.Outlined.EmojiEvents, null, tint = Amber, modifier = Modifier.size(32.dp))
                            }
                        }
                    }
                }

                itemsIndexed(available) { _, mission ->
                    MissionCard(
                        mission = mission,
                        onClick = { onMissionClick(mission.id) },
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 5.dp),
                    )
                }
            }
        }
    }
}

@Composable
private fun MissionCard(mission: Mission, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White, RoundedCornerShape(16.dp))
            .border(1.dp, Line, RoundedCornerShape(16.dp))
            .clickable { onClick() }
            .padding(14.dp),
    ) {
        Row(modifier = Modifier.padding(bottom = 10.dp), verticalAlignment = Alignment.CenterVertically) {
            Box(modifier = Modifier.background(GreenLight, RoundedCornerShape(10.dp)).padding(horizontal = 10.dp, vertical = 3.dp)) {
                Text(mission.tag.uppercase(), color = GreenDark, fontSize = 11.sp, fontWeight = FontWeight.Bold, letterSpacing = 0.4.sp)
            }
            Spacer(modifier = Modifier.weight(1f))
            Icon(Icons.Outlined.LocationOn, null, tint = Ink70, modifier = Modifier.size(14.dp))
            Text(mission.dist, color = Ink70, fontSize = 12.sp)
        }
        Text(mission.title, color = Ink, fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
        Text(mission.subtitle, color = Ink70, fontSize = 13.sp, lineHeight = 18.sp, modifier = Modifier.padding(vertical = 4.dp))
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
            XpChip(xp = mission.xp)
            if (mission.brl != "—") BrlChip(mission.brl)
            Spacer(modifier = Modifier.weight(1f))
            Icon(Icons.Outlined.AccessTime, null, tint = Ink50, modifier = Modifier.size(12.dp))
            Text(mission.time, color = Ink50, fontSize = 12.sp)
        }
    }
}

@Preview(showBackground = true, widthDp = 412, heightDp = 892)
@Composable
private fun MissionsPreview() {
    MissionsScreen(navController = rememberNavController())
}
