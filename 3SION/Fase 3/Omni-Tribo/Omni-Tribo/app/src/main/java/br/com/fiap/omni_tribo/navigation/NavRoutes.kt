package br.com.fiap.omni_tribo.navigation

sealed class Destination(val route: String) {
    object OnboardingScreen : Destination("onboarding")
    object MapScreen : Destination("map")
    object MissionsScreen : Destination("missions")
    object WalletScreen : Destination("wallet")
    object ProfileScreen : Destination("profile")

    object MissionDetailScreen : Destination("mission_detail/{missionId}") {
        fun createRoute(missionId: Int) = "mission_detail/$missionId"
    }

    object CreateMissionScreen : Destination("create_mission/{step}") {
        fun createRoute(step: Int = 1) = "create_mission/$step"
    }
}
