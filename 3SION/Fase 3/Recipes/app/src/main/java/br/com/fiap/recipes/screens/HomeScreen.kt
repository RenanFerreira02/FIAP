package br.com.fiap.recipes.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.fiap.recipes.R
import br.com.fiap.recipes.components.CategoryItem
import br.com.fiap.recipes.components.RecipeItem
import br.com.fiap.recipes.navigation.Destination
import br.com.fiap.recipes.repository.getAllCategories
import br.com.fiap.recipes.repository.getAllRecipes
import br.com.fiap.recipes.ui.theme.RecipesTheme

@Composable
fun HomeScreen(email: String, navController: NavController) {
    Surface(modifier = Modifier.fillMaxSize()) {
        Scaffold(topBar = {
            MyTopAppBar(email)
        }, bottomBar = {
            MyBottomAppBar()
        }, floatingActionButton = {
            FloatingActionButton(
                onClick = {},
                shape = CircleShape,
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "",
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }
        }) { paddingValues ->
            Column(
                modifier = Modifier.padding(paddingValues)
            ) {
                ContentScreen(navController)
            }
        }
    }
}

@Composable
fun ContentScreen(navController: NavController) {

    val categories = getAllCategories();

    val recipes = getAllRecipes()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        OutlinedTextField(
            value = "",
            onValueChange = {},
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = Color.Transparent,
                unfocusedContainerColor = Color(0xFFF5F5F5),
                focusedContainerColor = Color.LightGray,
            ),
            trailingIcon = {
                IconButton(
                    onClick = {}) {
                    Icon(
                        imageVector = Icons.Default.Search, contentDescription = ""
                    )
                }
            },
            placeholder = {
                Text(text = stringResource(R.string.search_by_recipes))
            })

        Card(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp) // modificado
                .fillMaxWidth()
                .height(112.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.cooking_card),
                contentDescription = "",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }
        Text(
            text = "Categories",
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp) // modificado
        )

        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
        ) {
            items(categories) { category ->
                CategoryItem(
                    category = category, onClick = {
                        navController.navigate(
                            route = Destination.CategoryRecipeScreen.createRoute(categoryId = category.id)
                        )
                    })
            }
        }

        Text(
            text = "Newly added recipes",
            style = MaterialTheme.typography.labelMedium,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
        )
        LazyColumn(
            contentPadding = PaddingValues(
                vertical = 16.dp, horizontal = 16.dp
            ), verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(recipes) { recipe ->
                RecipeItem(recipe)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTopAppBar(email: String = "") {
    TopAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .padding(0.dp), title = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(
                    modifier = Modifier.weight(1f)
                ) {
                    Text(
                        text = "Hello, João!",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.primary,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = email, style = MaterialTheme.typography.displaySmall
                    )
                }
                Card(
                    shape = CircleShape, colors = CardDefaults.cardColors(
                        containerColor = Color.Transparent
                    ), border = BorderStroke(
                        width = 1.dp, color = MaterialTheme.colorScheme.primary
                    )
                ) {
                    Image(
                        painter = painterResource(R.drawable.user), contentDescription = ""
                    )
                }
            }
        })
}

data class BottomNavigationItem(
    val title: String, val icon: ImageVector
)

@Composable
fun MyBottomAppBar() {
    val items = listOf(
        BottomNavigationItem(title = "Home", icon = Icons.Default.Home),
        BottomNavigationItem("Favorites", Icons.Default.Favorite),
        BottomNavigationItem("Profile", Icons.Default.Person)
    )
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.tertiary
    ) {
        items.forEach { item ->
            NavigationBarItem(selected = false, onClick = {}, icon = {
                Icon(
                    imageVector = item.icon,
                    contentDescription = item.title,
                    tint = MaterialTheme.colorScheme.onTertiary,
                    modifier = Modifier.size(24.dp)
                )
            }, label = {
                Text(
                    text = item.title,
                    style = MaterialTheme.typography.displaySmall,
                    color = MaterialTheme.colorScheme.onTertiary
                )
            })
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    RecipesTheme {
        HomeScreen("", rememberNavController())
    }

}