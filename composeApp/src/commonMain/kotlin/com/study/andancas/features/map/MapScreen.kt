package com.study.andancas.features.map

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.study.andancas.ui.BottomBar
import com.study.andancas.ui.Header
//import com.google.maps.android.compose.GoogleMap

@Composable
fun MapScreen(
    modifier: Modifier = Modifier,
    onBackPressed: () -> Unit,
    navController: NavHostController
){
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .systemBarsPadding(),

        topBar = {
            Header(
                title = "LOCALIZAÇÃO",
                showBackButton = true,
                showMenuIcon = true,
                onBackClick = onBackPressed
            )
        },

        bottomBar = { BottomBar( navController = navController) }
    ) {

        Column(
            modifier = Modifier
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = 64.dp, start = 16.dp, end = 16.dp)
                    .height(280.dp)
                    .background(color = Color.LightGray),
                contentAlignment = Alignment.Center // Centraliza o conteúdo
            ) {
                Text(text = "[Mapa]")
            }


        }

    }

}

