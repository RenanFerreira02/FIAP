package br.com.fiap.omni_tribo.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import br.com.fiap.omni_tribo.navigation.Destination
import br.com.fiap.omni_tribo.ui.theme.*

@Composable
fun OmniTopBar(
    title: String,
    onBack: (() -> Unit)? = null,
    darkBackground: Boolean = false,
) {
    val bg = if (darkBackground) GreenDark else Color.White
    val fg = if (darkBackground) Color.White else Ink

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(bg)
            .statusBarsPadding()
    ) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        IconButton(onClick = { onBack?.invoke() }) {
            if (onBack != null) {
                Icon(Icons.AutoMirrored.Outlined.ArrowBack, contentDescription = "Voltar", tint = fg)
            } else {
                Box(
                    modifier = Modifier
                        .size(28.dp)
                        .background(GreenLight, CircleShape)
                        .border(1.5.dp, GreenPrimary, CircleShape),
                )
            }
        }

        Text(
            text = title,
            modifier = Modifier.weight(1f),
            color = fg,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold,
            letterSpacing = 0.1.sp,
        )

        Box(modifier = Modifier.size(44.dp), contentAlignment = Alignment.Center) {
            Icon(Icons.Outlined.Notifications, contentDescription = "Notificações", tint = fg)
            Box(
                modifier = Modifier
                    .size(8.dp)
                    .align(Alignment.TopEnd)
                    .offset(x = (-10).dp, y = 9.dp)
                    .background(Coral, CircleShape)
                    .border(1.5.dp, bg, CircleShape),
            )
        }

        Box(
            modifier = Modifier
                .padding(end = 8.dp)
                .size(30.dp)
                .background(GreenLight, CircleShape)
                .border(1.5.dp, GreenPrimary, CircleShape),
            contentAlignment = Alignment.Center,
        ) {
            Text("RM", color = GreenDark, fontSize = 12.sp, fontWeight = FontWeight.Bold)
        }
    }
    }
}

@Composable
fun OmniBottomNav(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    val activeTab = when (currentRoute) {
        Destination.MapScreen.route -> 0
        Destination.MissionsScreen.route -> 1
        Destination.WalletScreen.route -> 2
        Destination.ProfileScreen.route -> 3
        else -> 0
    }

    val tabs = listOf(
        Triple("Mapa", Icons.Outlined.Map, Destination.MapScreen.route),
        Triple("Missões", Icons.Outlined.TrackChanges, Destination.MissionsScreen.route),
        Triple("Carteira", Icons.Outlined.AccountBalanceWallet, Destination.WalletScreen.route),
        Triple("Perfil", Icons.Outlined.Person, Destination.ProfileScreen.route),
    )

    NavigationBar(
        containerColor = Color.White,
        tonalElevation = 0.dp,
        modifier = Modifier.height(72.dp),
    ) {
        tabs.forEachIndexed { index, (label, icon, route) ->
            NavigationBarItem(
                selected = index == activeTab,
                onClick = {
                    if (currentRoute != route) {
                        navController.navigate(route) {
                            popUpTo(Destination.MapScreen.route) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                icon = { Icon(icon, contentDescription = label, modifier = Modifier.size(22.dp)) },
                label = {
                    Text(
                        text = label,
                        fontSize = 11.sp,
                        fontWeight = if (index == activeTab) FontWeight.SemiBold else FontWeight.Normal,
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = GreenPrimary,
                    selectedTextColor = GreenPrimary,
                    unselectedIconColor = Ink50,
                    unselectedTextColor = Ink50,
                    indicatorColor = GreenLight,
                ),
            )
        }
    }
}

@Composable
fun OmniFab(onClick: () -> Unit) {
    FloatingActionButton(
        onClick = onClick,
        containerColor = Coral,
        contentColor = Color.White,
        shape = RoundedCornerShape(18.dp),
        elevation = FloatingActionButtonDefaults.elevation(8.dp),
    ) {
        Icon(Icons.Outlined.Add, contentDescription = "Nova missão", modifier = Modifier.size(26.dp))
    }
}

@Composable
fun XpChip(xp: Int) {
    Row(
        modifier = Modifier
            .background(AmberLight, RoundedCornerShape(8.dp))
            .padding(horizontal = 8.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
    ) {
        Icon(Icons.Outlined.Bolt, contentDescription = null, tint = Amber, modifier = Modifier.size(12.dp))
        Text("+$xp XP", color = Amber, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
    }
}

@Composable
fun BrlChip(value: String) {
    Box(
        modifier = Modifier
            .background(GreenLight, RoundedCornerShape(8.dp))
            .padding(horizontal = 8.dp, vertical = 4.dp),
    ) {
        Text("R$ $value", color = GreenDark, fontSize = 12.sp, fontWeight = FontWeight.SemiBold)
    }
}
