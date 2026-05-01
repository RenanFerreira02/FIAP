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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import androidx.compose.ui.platform.LocalContext
import br.com.fiap.omni_tribo.components.*
import br.com.fiap.omni_tribo.navigation.Destination
import br.com.fiap.omni_tribo.repository.UserRepository
import br.com.fiap.omni_tribo.ui.theme.*
import br.com.fiap.omni_tribo.utils.toFormattedXp

private data class Transaction(val isCredit: Boolean, val isAmber: Boolean = false, val title: String, val meta: String, val amount: String, val sub: String)

private val transactions = listOf(
    Transaction(true, false, "Missão · Cesta orgânica", "Hoje, 11:42", "+240 XP", "R$ 18,00"),
    Transaction(true, true, "Bônus sequência · 7 dias", "Hoje, 09:00", "+100 XP", "Conquista"),
    Transaction(false, false, "Resgate · Camiseta da Tribo", "Ontem, 18:20", "−1.200 XP", "—"),
    Transaction(true, false, "Missão · Coleta recicláveis", "Ontem, 15:08", "+480 XP", "R$ 32,00"),
    Transaction(true, false, "Indicação · Lucas P.", "23 mai", "+300 XP", "Bônus tribo"),
)

@Composable
fun WalletScreen(
    navController: NavController,
) {
    val userRepository = UserRepository(LocalContext.current)
    val profile = userRepository.getProfile()
    val xpProgress = profile.xp.toFloat() / profile.xpThreshold.toFloat()

    Scaffold(
        topBar = { OmniTopBar(title = "Carteira") },
        bottomBar = { OmniBottomNav(navController = navController) },
        floatingActionButton = { OmniFab(onClick = { navController.navigate(Destination.CreateMissionScreen.createRoute(1)) }) },
        containerColor = Paper,
    ) { paddingValues ->
        Column(
            modifier = Modifier.fillMaxSize().padding(paddingValues).verticalScroll(rememberScrollState()),
        ) {
            // Hero balance card
            Box(
                modifier = Modifier.padding(16.dp).fillMaxWidth().clip(RoundedCornerShape(18.dp)).background(GreenDark).padding(18.dp),
            ) {
                Box(modifier = Modifier.size(140.dp).align(Alignment.TopEnd).offset(x = 30.dp, y = (-30).dp).background(Color.White.copy(alpha = 0.20f), CircleShape))
                Column {
                    Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                        Icon(Icons.Outlined.Bolt, null, tint = Amber, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(8.dp))
                        Text("SALDO DE XP", color = Color.White.copy(alpha = 0.85f), fontSize = 11.sp, fontWeight = FontWeight.Bold, letterSpacing = 0.6.sp)
                        Spacer(modifier = Modifier.weight(1f))
                        Text("Nível ${profile.level}", color = Color.White.copy(alpha = 0.65f), fontSize = 11.sp)
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(verticalAlignment = Alignment.Bottom, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                        Text(profile.xp.toFormattedXp(), color = Color.White, fontSize = 36.sp, fontWeight = FontWeight.Bold, letterSpacing = (-0.5).sp)
                        Text("XP", color = Color.White.copy(alpha = 0.7f), fontSize = 14.sp, modifier = Modifier.padding(bottom = 4.dp))
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Text("${profile.xpThreshold - profile.xp} XP até o nível ${profile.level + 1}", color = Color.White.copy(alpha = 0.7f), fontSize = 11.sp)
                    Spacer(modifier = Modifier.height(4.dp))
                    Box(modifier = Modifier.fillMaxWidth().height(6.dp).background(Color.White.copy(alpha = 0.18f), RoundedCornerShape(3.dp))) {
                        Box(modifier = Modifier.fillMaxWidth(xpProgress.coerceIn(0f, 1f)).fillMaxHeight().background(Amber, RoundedCornerShape(3.dp)))
                    }
                    Spacer(modifier = Modifier.height(14.dp))
                    Row(horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                        BalanceSubCard("Saldo R$", "R$ ${"%.2f".format(profile.brl).replace(".", ",")}", Modifier.weight(1f))
                        BalanceSubCard("Tokens", "${profile.tokens} ★", Modifier.weight(1f))
                    }
                }
            }

            // Quick actions
            Row(modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                QuickAction(Icons.Outlined.ArrowUpward, "Sacar", Modifier.weight(1f))
                QuickAction(Icons.Outlined.QrCode, "Pagar", Modifier.weight(1f))
                QuickAction(Icons.Outlined.ArrowDownward, "Receber", Modifier.weight(1f))
                QuickAction(Icons.Outlined.EmojiEvents, "Resgatar", Modifier.weight(1f))
            }

            // Tabs
            Row(modifier = Modifier.padding(horizontal = 16.dp, vertical = 14.dp), horizontalArrangement = Arrangement.spacedBy(14.dp), verticalAlignment = Alignment.CenterVertically) {
                listOf("Histórico", "Conquistas", "Recompensas").forEachIndexed { i, tab ->
                    Text(
                        text = tab,
                        color = if (i == 0) Ink else Ink50,
                        fontSize = 13.sp,
                        fontWeight = if (i == 0) FontWeight.Bold else FontWeight.Normal,
                        modifier = if (i == 0) Modifier.drawBehind {
                            drawLine(GreenPrimary, Offset(0f, size.height + 4.dp.toPx()), Offset(size.width, size.height + 4.dp.toPx()), 2.dp.toPx())
                        } else Modifier,
                    )
                }
            }

            // Transactions
            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                transactions.forEachIndexed { index, tx ->
                    TransactionRow(tx = tx)
                    if (index < transactions.size - 1) HorizontalDivider(color = Line)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
private fun BalanceSubCard(label: String, value: String, modifier: Modifier = Modifier) {
    Column(modifier = modifier.background(Color.White.copy(alpha = 0.12f), RoundedCornerShape(10.dp)).padding(horizontal = 12.dp, vertical = 10.dp)) {
        Text(label, color = Color.White.copy(alpha = 0.7f), fontSize = 12.sp)
        Spacer(modifier = Modifier.height(2.dp))
        Text(value, color = Color.White, fontSize = 16.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
private fun QuickAction(icon: ImageVector, label: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.background(Color.White, RoundedCornerShape(12.dp)).border(1.dp, Line, RoundedCornerShape(12.dp)).padding(vertical = 10.dp, horizontal = 4.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(6.dp),
    ) {
        Box(modifier = Modifier.size(32.dp).background(GreenLight, CircleShape), contentAlignment = Alignment.Center) {
            Icon(icon, null, tint = GreenPrimary, modifier = Modifier.size(18.dp))
        }
        Text(label, fontSize = 11.sp, fontWeight = FontWeight.SemiBold, color = Ink)
    }
}

@Composable
private fun TransactionRow(tx: Transaction) {
    Row(modifier = Modifier.fillMaxWidth().padding(vertical = 10.dp), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(12.dp)) {
        val bgColor = when { tx.isAmber -> AmberLight; tx.isCredit -> GreenLight; else -> CoralLight }
        val iconTint = when { tx.isAmber -> Amber; tx.isCredit -> GreenDark; else -> Coral }
        Box(modifier = Modifier.size(36.dp).background(bgColor, CircleShape), contentAlignment = Alignment.Center) {
            Icon(if (tx.isCredit) Icons.Outlined.ArrowDownward else Icons.Outlined.ArrowUpward, null, tint = iconTint, modifier = Modifier.size(16.dp))
        }
        Column(modifier = Modifier.weight(1f)) {
            Text(tx.title, color = Ink, fontSize = 13.sp, fontWeight = FontWeight.SemiBold)
            Text(tx.meta, color = Ink50, fontSize = 11.sp)
        }
        Column(horizontalAlignment = Alignment.End) {
            Text(tx.amount, color = if (tx.isCredit) GreenDark else Coral, fontSize = 13.sp, fontWeight = FontWeight.Bold)
            Text(tx.sub, color = Ink50, fontSize = 11.sp)
        }
    }
}

@Preview(showBackground = true, widthDp = 412, heightDp = 892)
@Composable
private fun WalletPreview() {
    WalletScreen(navController = rememberNavController())
}
