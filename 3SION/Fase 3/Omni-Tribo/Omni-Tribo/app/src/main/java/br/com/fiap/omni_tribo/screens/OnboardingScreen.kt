package br.com.fiap.omni_tribo.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.omni_tribo.ui.theme.*

@Composable
fun OnboardingScreen(
    onStart: () -> Unit,
    onLogin: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(GreenDark),
    ) {
        Box(
            modifier = Modifier
                .size(220.dp)
                .offset(x = 210.dp, y = (-40).dp)
                .background(Color(0x2EBA7517), CircleShape),
        )
        Box(
            modifier = Modifier
                .size(180.dp)
                .offset(x = (-60).dp, y = 120.dp)
                .background(Color(0x26D85A30), CircleShape),
        )

        Column(modifier = Modifier.fillMaxSize()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 18.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    Box(
                        modifier = Modifier
                            .size(28.dp)
                            .background(Amber, CircleShape),
                        contentAlignment = Alignment.Center,
                    ) {
                        Icon(Icons.Outlined.Groups, contentDescription = null, tint = GreenDark, modifier = Modifier.size(16.dp))
                    }
                    Text("Omni-Tribo", color = Color.White, fontWeight = FontWeight.ExtraBold, fontSize = 16.sp, letterSpacing = 0.4.sp)
                }
                Text("Pular", color = Color.White.copy(alpha = 0.7f), fontSize = 13.sp)
            }

            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
            ) {
                Box(modifier = Modifier.size(220.dp), contentAlignment = Alignment.Center) {
                    Box(modifier = Modifier.fillMaxSize().background(Color.White.copy(alpha = 0.06f), CircleShape))
                    Box(
                        modifier = Modifier
                            .size(140.dp)
                            .background(GreenPrimary, CircleShape),
                        contentAlignment = Alignment.Center,
                    ) {
                        Icon(Icons.Outlined.Map, contentDescription = null, tint = Color.White, modifier = Modifier.size(80.dp))
                    }
                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .align(Alignment.TopStart)
                            .offset(x = (-4).dp, y = 20.dp)
                            .background(Coral, CircleShape)
                            .border(3.dp, Color.White.copy(alpha = 0.95f), CircleShape),
                        contentAlignment = Alignment.Center,
                    ) {
                        Icon(Icons.Outlined.TrackChanges, null, tint = Color.White, modifier = Modifier.size(22.dp))
                    }
                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .align(Alignment.TopEnd)
                            .offset(x = 4.dp, y = 40.dp)
                            .background(Amber, CircleShape)
                            .border(3.dp, Color.White.copy(alpha = 0.95f), CircleShape),
                        contentAlignment = Alignment.Center,
                    ) {
                        Icon(Icons.Outlined.Bolt, null, tint = Color.White, modifier = Modifier.size(22.dp))
                    }
                    Box(
                        modifier = Modifier
                            .size(48.dp)
                            .align(Alignment.BottomStart)
                            .background(GreenLight, CircleShape)
                            .border(3.dp, Color.White.copy(alpha = 0.95f), CircleShape),
                        contentAlignment = Alignment.Center,
                    ) {
                        Icon(Icons.Outlined.Groups, null, tint = GreenDark, modifier = Modifier.size(22.dp))
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))
                Text(
                    text = "Sua tribo,\nsua missão.",
                    color = Color.White,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 26.sp,
                    textAlign = TextAlign.Center,
                    lineHeight = 30.sp,
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "Conecte-se com vizinhos, complete missões locais e ganhe XP enquanto fortalece sua comunidade.",
                    color = Color.White.copy(alpha = 0.78f),
                    fontSize = 14.sp,
                    textAlign = TextAlign.Center,
                    lineHeight = 21.sp,
                    modifier = Modifier.padding(horizontal = 24.dp),
                )
                Spacer(modifier = Modifier.height(28.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                    Box(modifier = Modifier.size(width = 24.dp, height = 6.dp).background(Amber, RoundedCornerShape(3.dp)))
                    Box(modifier = Modifier.size(6.dp).background(Color.White.copy(alpha = 0.3f), CircleShape))
                    Box(modifier = Modifier.size(6.dp).background(Color.White.copy(alpha = 0.3f), CircleShape))
                }
            }

            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp)
                        .background(Coral, RoundedCornerShape(16.dp))
                        .clickable { onStart() },
                    contentAlignment = Alignment.Center,
                ) {
                    Text("Começar minha tribo", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 15.sp)
                }
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp)
                        .border(1.5.dp, Color.White.copy(alpha = 0.4f), RoundedCornerShape(16.dp))
                        .clickable { onLogin() },
                    contentAlignment = Alignment.Center,
                ) {
                    Text("Já tenho conta", color = Color.White, fontWeight = FontWeight(600), fontSize = 14.sp)
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 412, heightDp = 892)
@Composable
private fun OnboardingPreview() {
    OnboardingScreen(onStart = {}, onLogin = {})
}
