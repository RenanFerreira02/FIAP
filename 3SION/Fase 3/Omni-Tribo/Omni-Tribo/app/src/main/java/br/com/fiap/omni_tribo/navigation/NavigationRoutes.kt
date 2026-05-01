package br.com.fiap.omni_tribo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import br.com.fiap.omni_tribo.screens.CreateMissionScreen
import br.com.fiap.omni_tribo.screens.MapScreen
import br.com.fiap.omni_tribo.screens.MissionDetailScreen
import br.com.fiap.omni_tribo.screens.MissionsScreen
import br.com.fiap.omni_tribo.screens.OnboardingScreen
import br.com.fiap.omni_tribo.screens.ProfileScreen
import br.com.fiap.omni_tribo.screens.WalletScreen

@Composable
fun NavigationRoutes() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Destination.OnboardingScreen.route) {

        composable(Destination.OnboardingScreen.route) {
            OnboardingScreen(
                onStart = {
                    navController.navigate(Destination.MapScreen.route) {
                        popUpTo(Destination.OnboardingScreen.route) { inclusive = true }
                    }
                },
                onLogin = {
                    navController.navigate(Destination.MapScreen.route) {
                        popUpTo(Destination.OnboardingScreen.route) { inclusive = true }
                    }
                },
            )
        }

        composable(Destination.MapScreen.route) {
            MapScreen(
                navController = navController,
                onMissionClick = { missionId ->
                    navController.navigate(Destination.MissionDetailScreen.createRoute(missionId))
                },
            )
        }

        composable(Destination.MissionsScreen.route) {
            MissionsScreen(
                navController = navController,
                onMissionClick = { missionId ->
                    navController.navigate(Destination.MissionDetailScreen.createRoute(missionId))
                },
            )
        }

        composable(Destination.WalletScreen.route) {
            WalletScreen(navController = navController)
        }

        composable(Destination.ProfileScreen.route) {
            ProfileScreen(navController = navController)
        }

        composable(
            route = Destination.MissionDetailScreen.route,
            arguments = listOf(navArgument("missionId") { type = NavType.IntType }),
        ) { backStackEntry ->
            val missionId = backStackEntry.arguments?.getInt("missionId") ?: 1
            MissionDetailScreen(
                missionId = missionId,
                navController = navController,
            )
        }

        composable(
            route = Destination.CreateMissionScreen.route,
            arguments = listOf(navArgument("step") { type = NavType.IntType }),
        ) { backStackEntry ->
            val step = backStackEntry.arguments?.getInt("step") ?: 1
            CreateMissionScreen(
                step = step,
                navController = navController,
                onBack = {
                    if (!navController.popBackStack()) {
                        navController.navigate(Destination.MissionsScreen.route)
                    }
                },
                onNext = {
                    if (step < 2) {
                        navController.navigate(Destination.CreateMissionScreen.createRoute(2))
                    } else {
                        navController.navigate(Destination.MissionsScreen.route) {
                            popUpTo(Destination.MapScreen.route) { inclusive = false }
                        }
                    }
                },
            )
        }
    }
}
