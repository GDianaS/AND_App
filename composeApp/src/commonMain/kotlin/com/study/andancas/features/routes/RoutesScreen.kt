package com.study.andancas.features.routes

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.study.andancas.ui.BottomBar
import com.study.andancas.ui.Header

@Composable
fun RoutesScreen(
    modifier: Modifier = Modifier,
    onBackPressed: () -> Unit,
    navigateToRouteDetailsScreen: () -> Unit,
    routes: List<Route> = sampleRoutes,
    navController: NavHostController
){
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding(),

        topBar = {
            Header(
                title = "Roteiros",
                showBackButton = true,
                onBackClick = { /* ação */ },
                showMenuIcon = true,
                onMenuClick = { /* ação */ }
        )
        },

        bottomBar = { BottomBar(navController = navController ) }
    ) {

        Column(
            modifier = Modifier
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {

            Text(
                text = "Santarém, PA",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.8f),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth().padding(top = 56.dp)
            )

            LazyVerticalGrid(
                columns = GridCells.Adaptive(160.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(routes){ route ->
                    RouteCard(route = route, onClick = navigateToRouteDetailsScreen)
                }
            }


        }
    }
}


@Composable
fun RouteCard(route: Route,
              onClick: () -> Unit = {}){
    Card(

        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f) // para manter os cards proporcionais
            .clickable(onClick = onClick)
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = route.title,
                style = MaterialTheme.typography.titleMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = route.description,
                style = MaterialTheme.typography.bodySmall,
                color = Color.Gray,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(vertical = 4.dp)
            )

            Spacer(modifier = Modifier.weight(1f))

            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(Icons.Default.Favorite, contentDescription = "Favoritos", tint = Color.Red)
                Text(text = route.favorites.toString())

                Icon(Icons.Default.Info, contentDescription = "Comentários", tint = Color.Blue)
                Text(text = route.comments.toString())
            }
        }
    }
}


// Dados de exemplo
data class Route(
    val title: String,
    val description: String,
    val favorites: Int,
    val comments: Int
)

val sampleRoutes = listOf(
    Route("Religião", "Aprecie um momento religoso", 25, 10),
    Route("Arquitetura", "Visite construções históricas", 40, 18),
    Route("Cultura", "Aprecie pontos de caracter cultural", 15, 5),
    Route("Culinária", "Visite restaurante e prove de comidas regionais.", 10, 2)
)
