package com.study.andancas.features.routesdetails

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.study.andancas.ui.BottomBar
import com.study.andancas.ui.Header

@Composable
fun RoutesDetailsScreen(
    modifier: Modifier = Modifier,
    onBackPressed : () -> Unit,
    navController: NavHostController
){
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding(),

        topBar = {
            Header(
                title = "ROTEIRO DETALHES",
                showBackButton = true,
                showMenuIcon = true,
                onBackClick = onBackPressed
            )
        },

        bottomBar = { BottomBar(navController = navController ) }
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
            ) {


            // Dados de exemplo para a roteiro
            val routeData = RouteData(
                title = "Religiosa",
                description = "Uma rota que explora os principais pontos religiosos da cidade, incluindo igrejas históricas, catedrais e templos de diversas religiões. Cada local tem uma rica história e arquitetura única que representa a diversidade cultural e espiritual da região.",
                places = listOf(
                    PlaceInfo(
                        id = "1",
                        name = "Catedral Metropolitana",
                        description = "Catedral histórica construída no século XVIII com impressionante arquitetura barroca.",
                        favoriteCount = 128,
                        imageUrl = ""
                    ),
                    PlaceInfo(
                        id = "2",
                        name = "Igreja Nossa Senhora",
                        description = "Igreja em estilo neogótico com vitrais coloridos que datam do século XIX.",
                        favoriteCount = 93,
                        imageUrl = ""
                    ),
                    PlaceInfo(
                        id = "3",
                        name = "Templo Budista",
                        description = "Um templo tradicional que oferece um ambiente tranquilo para meditação e contemplação.",
                        favoriteCount = 85,
                        imageUrl = ""
                    ),
                    PlaceInfo(
                        id = "4",
                        name = "Mesquita Central",
                        description = "Uma bela mesquita com minaretes imponentes e decoração interior deslumbrante.",
                        favoriteCount = 76,
                        imageUrl = ""
                    ),
                    PlaceInfo(
                        id = "5",
                        name = "Sinagoga Histórica",
                        description = "Construída no início do século XX, possui uma rica história e detalhes arquitetônicos preservados.",
                        favoriteCount = 62,
                        imageUrl = ""
                    )
                )
            )

            // Título do roteiro

            Spacer(modifier = Modifier.height(32.dp))

            Text(
                text = routeData.title,
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Box com a descrição da rota
            Card(
                modifier = Modifier.fillMaxWidth(),
                colors = CardDefaults.cardColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant
                )
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Text(
                        text = "Descrição",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = routeData.description,
                        fontSize = 16.sp,
                        color = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.8f),
                        lineHeight = 24.sp
                    )
                }
            }

            // Título da seção de locais
            Text(
                text = "Locais",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onBackground
            )

            // Cards dos locais em uma linha horizontal rolável
            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                contentPadding = PaddingValues(end = 8.dp)
            ) {
                items(routeData.places) { place ->
                    PlaceCard(
                        placeInfo = place,
                        onClick = { /*TODO*/ }
                    )
                }
            }


        }

    }
}

@Composable
fun PlaceCard(
    placeInfo: PlaceInfo,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .width(220.dp),
        onClick = onClick,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Column {
            // Imagem ou placeholder
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.7f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(imageVector = Icons.Default.Place, contentDescription = null, modifier = Modifier.size(48.dp), tint = MaterialTheme.colorScheme.onPrimary)

                // Chip com número de favoritos
                Surface(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(8.dp),
                    shape = RoundedCornerShape(16.dp),
                    color = MaterialTheme.colorScheme.primaryContainer.copy(alpha = 0.9f)
                ) {
                    Row(
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Favorite,
                            contentDescription = null,
                            modifier = Modifier.size(16.dp),
                            tint = MaterialTheme.colorScheme.primary
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Text(
                            text = placeInfo.favoriteCount.toString(),
                            fontSize = 12.sp,
                            color = MaterialTheme.colorScheme.onPrimaryContainer
                        )
                    }
                }
            }

            // Conteúdo do card
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            ) {
                Text(
                    text = placeInfo.name,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = placeInfo.description,
                    fontSize = 14.sp,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis,
                    lineHeight = 18.sp
                )
            }
        }
    }
}


data class RouteData(
    val title: String,
    val description: String,
    val places: List<PlaceInfo>
)

data class PlaceInfo(
    val id: String,
    val name: String,
    val description: String,
    val favoriteCount: Int,
    val imageUrl: String
)