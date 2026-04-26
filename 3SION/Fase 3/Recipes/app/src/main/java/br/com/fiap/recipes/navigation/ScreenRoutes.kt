package br.com.fiap.recipes.navigation

sealed class Destination(val route: String){
    object InitialScreen: Destination("initial")
    object SignupScreen: Destination("signup")

    object HomeScreen: Destination("home/{email}"){
        fun createRoute(email: String): String {
            return "home/$email"
        }
    }

    // TRECHO DE CÓDIGO OMITIDO
    object CategoryRecipeScreen: Destination("categoryRecipes/{id}"){
        fun createRoute(categoryId: Int): String {
            return "categoryRecipes/$categoryId"
        }
    }
    // TRECHO DE CÓDIGO OMITIDO

    object LoginScreen: Destination("login")
}