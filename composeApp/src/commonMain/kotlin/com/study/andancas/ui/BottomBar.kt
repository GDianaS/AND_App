package com.study.andancas.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.study.andancas.navigation.routes.HomeRoutes

@Composable
fun BottomBar(
    modifier: Modifier = Modifier,
    navController: NavHostController
){
    BottomAppBar(
        actions = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround, // Distribui igualmente com espaço nas bordas
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = {
                    navController.navigate(HomeRoutes.Home)
                }) {
                    Icon(Icons.Filled.Home, contentDescription = "Localized description")
                }
                IconButton(onClick = {
                    navController.navigate(HomeRoutes.Map)
                }) {
                    Icon(
                        Icons.Filled.Place,
                        contentDescription = "Localized description",
                    )
                }
                IconButton(onClick = {
                    navController.navigate(HomeRoutes.Profile)
                }) {
                    Icon(
                        Icons.Filled.Person,
                        contentDescription = "Localized description",
                    )
                }

            }

        }

    )

}