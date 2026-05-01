package br.com.fiap.omni_tribo.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.omni_tribo.components.*
import br.com.fiap.omni_tribo.navigation.Destination
import br.com.fiap.omni_tribo.ui.theme.*

private val mapPins = listOf(
    Triple(0.28f, 0.32f, "3"),
    Triple(0.62f, 0.28f, "1"),
    Triple(0.48f, 0.50f, "5"),
    Triple(0.72f, 0.58f, "2"),
    Triple(0.22f, 0.62f, "1"),
)

@Composable
fun MapScreen(
    navController: NavController,
    onMissionClick: (Int) -> Unit = {},
) {
    Scaffold(
        topBar = { OmniTopBar(title = "Olá, Renata") },
        bottomBar = { OmniBottomNav(navController = navController) },
        floatingActionButton = { OmniFab(onClick = { navController.navigate(Destination.CreateMissionScreen.createRoute(1)) }) },
        containerColor = Paper,
    ) { paddingValues ->
        BoxWithConstraints(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
        ) {
            val mapWidth = maxWidth
            val mapHeight = maxHeight

            Canvas(modifier = Modifier.fillMaxSize()) {
                drawRect(Color(0xFFEAF1ED))
                val lineColor = Line.copy(alpha = 0.6f)
                val gridStep = 60.dp.toPx()
                var x = gridStep
                while (x < size.width) {
                    drawLine(lineColor, Offset(x, 0f), Offset(x, size.height), 1.dp.toPx())
                    x += gridStep
                }
                var y = gridStep
                while (y < size.height) {
                    drawLine(lineColor, Offset(0f, y), Offset(size.width, y), 1.dp.toPx())
                    y += gridStep
                }
                drawLine(lineColor, Offset(0f, size.height * 0.8f), Offset(size.width * 0.5f, size.height * 0.2f), 4.dp.toPx())
                drawLine(lineColor, Offset(size.width * 0.25f, 0f), Offset(size.width, size.height * 0.65f), 4.dp.toPx())
            }

            mapPins.forEach { (xFrac, yFrac, count) ->
                MapPin(
                    modifier = Modifier.offset(x = mapWidth * xFrac - 20.dp, y = mapHeight * yFrac - 52.dp),
                    count = count,
                )
            }

            Box(
                modifier = Modifier
                    .size(18.dp)
                    .offset(x = mapWidth * 0.5f - 9.dp, y = mapHeight * 0.7f - 9.dp)
                    .background(GreenPrimary.copy(alpha = 0.18f), CircleShape),
                contentAlignment = Alignment.Center,
            ) {
                Box(
                    modifier = Modifier
                        .size(14.dp)
                        .background(GreenPrimary.copy(alpha = 0.35f), CircleShape),
                    contentAlignment = Alignment.Center,
                ) {
                    Box(modifier = Modifier.size(10.dp).background(GreenPrimary, CircleShape).border(2.dp, Color.White, CircleShape))
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.TopStart)
                    .padding(horizontal = 12.dp, vertical = 12.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Row(
                    modifier = Modifier
                        .weight(1f)
                        .height(40.dp)
                        .shadow(4.dp, RoundedCornerShape(20.dp))
                        .background(Color.White, RoundedCornerShape(20.dp))
                        .padding(horizontal = 12.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    Icon(Icons.Outlined.Search, null, tint = Ink50, modifier = Modifier.size(18.dp))
                    Text("Buscar missões próximas", color = Ink50, fontSize = 14.sp)
                }
                Box(
                    modifier = Modifier.size(40.dp).shadow(4.dp, CircleShape).background(Color.White, CircleShape),
                    contentAlignment = Alignment.Center,
                ) {
                    Icon(Icons.Outlined.FilterList, null, tint = Ink, modifier = Modifier.size(18.dp))
                }
            }

            Row(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(start = 12.dp, top = 64.dp)
                    .fillMaxWidth()
                    .padding(end = 12.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                FilterChipItem("Todas · 12", active = true)
                FilterChipItem("Entrega")
                FilterChipItem("Coleta")
                FilterChipItem("Tribo")
            }

            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(12.dp)
                    .shadow(12.dp, RoundedCornerShape(18.dp))
                    .background(Color.White, RoundedCornerShape(18.dp))
                    .padding(14.dp),
            ) {
                Column {
                    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(bottom = 8.dp)) {
                        Box(modifier = Modifier.size(6.dp).background(Coral, CircleShape))
                        Spacer(modifier = Modifier.width(6.dp))
                        Text("Mais próxima · 320 m", color = Coral, fontSize = 11.sp, fontWeight = FontWeight.Bold, letterSpacing = 0.6.sp)
                        Spacer(modifier = Modifier.weight(1f))
                        Text("1 / 12", color = Ink50, fontSize = 11.sp)
                    }
                    Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                        Box(
                            modifier = Modifier.size(56.dp).clip(RoundedCornerShape(8.dp)).background(GreenLight).border(1.dp, Line, RoundedCornerShape(8.dp)),
                            contentAlignment = Alignment.Center,
                        ) {
                            Text("img", color = Ink50, fontSize = 11.sp)
                        }
                        Column(modifier = Modifier.weight(1f)) {
                            Text("Entregar cesta orgânica", color = Ink, fontWeight = FontWeight.SemiBold, fontSize = 15.sp)
                            Text("Vila Madalena → Pinheiros", color = Ink70, fontSize = 12.sp, modifier = Modifier.padding(vertical = 2.dp))
                            Row(horizontalArrangement = Arrangement.spacedBy(6.dp), verticalAlignment = Alignment.CenterVertically) {
                                XpChip(xp = 240)
                                BrlChip("18")
                                Spacer(modifier = Modifier.weight(1f))
                                Icon(Icons.Outlined.AccessTime, null, tint = Ink50, modifier = Modifier.size(12.dp))
                                Text("25 min", color = Ink50, fontSize = 11.sp)
                            }
                        }
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(44.dp)
                            .background(GreenPrimary, RoundedCornerShape(12.dp))
                            .clickable { onMissionClick(1) },
                        contentAlignment = Alignment.Center,
                    ) {
                        Text("Aceitar missão", color = Color.White, fontWeight = FontWeight.SemiBold, fontSize = 14.sp)
                    }
                }
            }
        }
    }
}

@Composable
private fun MapPin(modifier: Modifier = Modifier, count: String) {
    Column(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally) {
        Box(
            modifier = Modifier
                .defaultMinSize(minWidth = 36.dp)
                .height(36.dp)
                .background(Coral, RoundedCornerShape(18.dp))
                .border(2.dp, Color.White, RoundedCornerShape(18.dp))
                .padding(horizontal = 8.dp),
            contentAlignment = Alignment.Center,
        ) {
            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                Icon(Icons.Outlined.TrackChanges, null, tint = Color.White, modifier = Modifier.size(14.dp))
                Text(count, color = Color.White, fontSize = 13.sp, fontWeight = FontWeight.Bold)
            }
        }
        Canvas(modifier = Modifier.size(width = 10.dp, height = 8.dp)) {
            val path = Path().apply {
                moveTo(0f, 0f); lineTo(size.width, 0f); lineTo(size.width / 2f, size.height); close()
            }
            drawPath(path, Color(0xFFD85A30))
        }
    }
}

@Composable
private fun FilterChipItem(label: String, active: Boolean = false) {
    Box(
        modifier = Modifier
            .height(32.dp)
            .shadow(if (active) 0.dp else 2.dp, RoundedCornerShape(16.dp))
            .background(if (active) GreenPrimary else Color.White, RoundedCornerShape(16.dp))
            .padding(horizontal = 14.dp),
        contentAlignment = Alignment.Center,
    ) {
        Text(label, color = if (active) Color.White else Ink70, fontSize = 13.sp, fontWeight = FontWeight.Medium)
    }
}

@Preview(showBackground = true, widthDp = 412, heightDp = 892)
@Composable
private fun MapScreenPreview() {
    MapScreen(navController = rememberNavController())
}
