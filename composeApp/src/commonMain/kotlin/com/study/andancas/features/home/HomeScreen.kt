package com.study.andancas.features.home

import andancasappproject.composeapp.generated.resources.Res
import andancasappproject.composeapp.generated.resources.favorites
import andancasappproject.composeapp.generated.resources.map
import andancasappproject.composeapp.generated.resources.routes
import andancasappproject.composeapp.generated.resources.loveyou
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.scrollable
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.study.andancas.domain.RequestState
import com.study.andancas.ui.BottomBar
import com.study.andancas.ui.Header
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource
import com.study.andancas.components.getLocation


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onBackPressed: () -> Unit,
    navigateToRouteScreen: () -> Unit,
    navController: NavHostController
){

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding(),

        topBar = {Header(
            title = "HOME",
            showBackButton = true,
            showMenuIcon = true,
            onBackClick = onBackPressed,
        )},

        bottomBar = { BottomBar(navController = navController) }
    ){

        Column ( modifier = Modifier
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

            //Spacer(modifier.height(8.dp))
            WelcomeBanner(username = "Diana")

            Text(
                text = "Descubra",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 4.dp)
            )

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                contentPadding = PaddingValues(vertical = 8.dp, horizontal = 8.dp)
            ) {
                item{
                    CardOptions(
                        title = "Roteiros",
                        imageResource = Res.drawable.routes,
                        onClick = navigateToRouteScreen
                    )
                }

                item{
                    CardOptions(
                        title = "Mapa",
                        imageResource = Res.drawable.map,
                        onClick = { /*TODO*/}
                    )
                }

                item{
                    CardOptions(
                        title = "Favoritos",
                        imageResource = Res.drawable.favorites,
                        onClick = { /*TODO*/}
                    )
                }

                }

            Text(
                text = "Avisos",
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 4.dp)
            )

            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Box(modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .background(color = Color.LightGray)
                ){
                    Text(text = "Título")
                }

            }

        }
}
}

@Composable
private fun CardOptions(
    modifier: Modifier = Modifier,
    title: String,
    imageResource: DrawableResource,
    onClick: () -> Unit = {}
) {
    Card(
        modifier = modifier
            .width(150.dp)
            .clickable(onClick = onClick),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(imageResource),
                contentDescription = title,
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
            )

            Text(
                text = title,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = 12.dp, horizontal = 8.dp)
            )
        }
    }
}

@Composable
fun WelcomeBanner(username: String = "Usuário") {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(Res.drawable.loveyou),
            contentDescription = null,
            colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.onPrimaryContainer),
            modifier = Modifier.size(64.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(
                text = "Bem-vindo(a), $username!",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
            Text(
                text = "Explore novas aventuras por aí.",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onPrimaryContainer
            )
        }
    }
}

