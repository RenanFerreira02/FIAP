package br.com.fiap.omni_tribo.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.platform.LocalContext
import br.com.fiap.omni_tribo.components.*
import br.com.fiap.omni_tribo.model.UserProfile
import br.com.fiap.omni_tribo.navigation.Destination
import br.com.fiap.omni_tribo.repository.UserRepository
import br.com.fiap.omni_tribo.ui.theme.*

private data class Badge(val icon: ImageVector, val label: String, val color: Color)

private val badges = listOf(
    Badge(Icons.Outlined.LocalFireDepartment, "Sequência 7d", Coral),
    Badge(Icons.Outlined.EmojiEvents, "Top 10 SP", Amber),
    Badge(Icons.Outlined.Groups, "Líder Tribo", GreenDark),
    Badge(Icons.Outlined.Bolt, "50 missões", GreenPrimary),
    Badge(Icons.Outlined.StarBorder, "5★ confiança", Amber),
    Badge(Icons.Outlined.QrCode, "Verificada", GreenDark),
)

@Composable
fun ProfileScreen(
    navController: NavController,
) {
    val context = LocalContext.current
    val userRepository = remember { UserRepository(context) }
    val profile by userRepository.profileFlow.collectAsState(initial = UserProfile())
    val xpProgress = profile.xp.toFloat() / profile.xpThreshold.toFloat()
    val initials = profile.name.split(" ").take(2).mapNotNull { it.firstOrNull() }.joinToString("")

    Scaffold(
        topBar = { OmniTopBar(title = "Perfil") },
        bottomBar = { OmniBottomNav(navController = navController) },
        floatingActionButton = { OmniFab(onClick = { navController.navigate(Destination.CreateMissionScreen.route) }) },
        containerColor = Paper,
    ) { paddingValues ->
        Column(modifier = Modifier.fillMaxSize().padding(paddingValues).verticalScroll(rememberScrollState())) {

            // Identity header
            Column(modifier = Modifier.fillMaxWidth().background(GreenDark).padding(horizontal = 16.dp, vertical = 18.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(14.dp)) {
                    Box {
                        Box(
                            modifier = Modifier.size(72.dp).background(GreenLight, CircleShape).border(3.dp, Amber, CircleShape),
                            contentAlignment = Alignment.Center,
                        ) {
                            Text(initials, color = GreenDark, fontSize = 26.sp, fontWeight = FontWeight.Bold)
                        }
                        Box(
                            modifier = Modifier.size(26.dp).align(Alignment.BottomEnd).offset(x = 2.dp, y = 2.dp).background(Amber, CircleShape).border(2.dp, GreenDark, CircleShape),
                            contentAlignment = Alignment.Center,
                        ) {
                            Text("${profile.level}", color = Color.White, fontSize = 11.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                    Column(modifier = Modifier.weight(1f)) {
                        Text(profile.name, color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                        Text("${profile.handle} · ${profile.tribe}", color = Color.White.copy(alpha = 0.75f), fontSize = 12.sp, modifier = Modifier.padding(bottom = 6.dp))
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                            Icon(Icons.Outlined.LocalFireDepartment, null, tint = Coral, modifier = Modifier.size(14.dp))
                            Text("Sequência de ${profile.streak} dias", color = Color.White.copy(alpha = 0.85f), fontSize = 12.sp)
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))
                Row(modifier = Modifier.fillMaxWidth().background(Color.White.copy(alpha = 0.10f), RoundedCornerShape(12.dp)), verticalAlignment = Alignment.CenterVertically) {
                    listOf("${profile.missionsCompleted}" to "Missões", "${"%.1f".format(profile.rating)}★" to "Avaliação", "${profile.tribeMembers}" to "Tribo").forEachIndexed { i, (value, label) ->
                        if (i > 0) Box(modifier = Modifier.width(1.dp).height(48.dp).background(Color.White.copy(alpha = 0.15f)))
                        Column(modifier = Modifier.weight(1f).padding(vertical = 12.dp, horizontal = 8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(value, color = Color.White, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                            Text(label, color = Color.White.copy(alpha = 0.75f), fontSize = 11.sp)
                        }
                    }
                }
            }

            // Level progress
            Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 14.dp)) {
                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text("Nível ${profile.level} → ${profile.level + 1}", color = Ink, fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
                    Text("${profile.xp} / ${profile.xpThreshold} XP", color = Ink70, fontSize = 12.sp)
                }
                Spacer(modifier = Modifier.height(6.dp))
                Box(modifier = Modifier.fillMaxWidth().height(8.dp).background(Line, RoundedCornerShape(4.dp))) {
                    Box(modifier = Modifier.fillMaxWidth(xpProgress.coerceIn(0f, 1f)).fillMaxHeight().background(Amber, RoundedCornerShape(4.dp)))
                }
            }

            // Badges
            Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 6.dp)) {
                Row(modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                    Text("Conquistas", color = Ink, fontSize = 13.sp, fontWeight = FontWeight.Bold)
                    Text("Ver todas →", color = GreenPrimary, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
                }
                badges.chunked(3).forEach { row ->
                    Row(modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        row.forEach { BadgeItem(badge = it, modifier = Modifier.weight(1f)) }
                        repeat(3 - row.size) { Spacer(modifier = Modifier.weight(1f)) }
                    }
                }
            }

            // Settings list
            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                listOf(
                    Triple(Icons.Outlined.Groups, "Minha Tribo", "${profile.tribeMembers} membros"),
                    Triple(Icons.Outlined.TrackChanges, "Histórico de missões", "${profile.missionsCompleted}"),
                    Triple(Icons.Outlined.QrCode, "Verificação de identidade", "Ativa"),
                    Triple(Icons.Outlined.Person, "Configurações", ""),
                ).forEachIndexed { index, (icon, label, value) ->
                    Row(modifier = Modifier.fillMaxWidth().padding(vertical = 12.dp, horizontal = 4.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                        Icon(icon, null, tint = GreenPrimary, modifier = Modifier.size(20.dp))
                        Text(label, color = Ink, fontSize = 14.sp, modifier = Modifier.weight(1f))
                        if (value.isNotEmpty()) Text(value, color = Ink50, fontSize = 12.sp)
                        Icon(Icons.Outlined.KeyboardArrowRight, null, tint = Ink50, modifier = Modifier.size(16.dp))
                    }
                    if (index < 3) HorizontalDivider(color = Line)
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Credits
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .background(GreenLight, RoundedCornerShape(14.dp))
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(4.dp),
            ) {
                Text(
                    text = "Omni-Tribo · 2026",
                    color = GreenDark,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 0.4.sp,
                )
                Text("Renan Kaique · RM 555833", color = Ink70, fontSize = 12.sp)
                Text("Matheus Eduardo · RM 558232", color = Ink70, fontSize = 12.sp)
            }

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
private fun BadgeItem(badge: Badge, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.background(Color.White, RoundedCornerShape(12.dp)).border(1.dp, Line, RoundedCornerShape(12.dp)).padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(6.dp),
    ) {
        Box(modifier = Modifier.size(40.dp).background(GreenLight, CircleShape).border(2.dp, badge.color, CircleShape), contentAlignment = Alignment.Center) {
            Icon(badge.icon, null, tint = badge.color, modifier = Modifier.size(20.dp))
        }
        Text(badge.label, color = Ink, fontSize = 11.sp, fontWeight = FontWeight.SemiBold, textAlign = TextAlign.Center)
    }
}

@Preview(showBackground = true, widthDp = 412, heightDp = 892)
@Composable
private fun ProfilePreview() {
    ProfileScreen(navController = rememberNavController())
}
