package com.study.andancas

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import andancasappproject.composeapp.generated.resources.Res
import andancasappproject.composeapp.generated.resources.compose_multiplatform
import androidx.navigation.compose.rememberNavController
import com.study.andancas.features.map.MapScreen
import com.study.andancas.features.home.HomeScreen
import com.study.andancas.features.login.LoginScreen
import com.study.andancas.features.profile.ProfileScreen
import com.study.andancas.features.routes.RoutesScreen
import com.study.andancas.features.routesdetails.RoutesDetailsScreen
import com.study.andancas.features.singin.SignInScreen
import com.study.andancas.navigation.main.HomeNavHost

@Composable
@Preview
fun App() {
    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }

            HomeNavHost(navHostController = rememberNavController())

    }
}