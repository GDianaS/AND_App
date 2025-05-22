package com.study.andancas.navigation.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.study.andancas.features.home.HomeScreen
import com.study.andancas.features.login.LoginScreen
import com.study.andancas.features.map.MapScreen
import com.study.andancas.features.profile.ProfileScreen
import com.study.andancas.features.routes.RoutesScreen
import com.study.andancas.features.routesdetails.RoutesDetailsScreen
import com.study.andancas.features.singin.SignInScreen
import com.study.andancas.navigation.routes.HomeRoutes

@Composable
fun HomeNavHost(
    modifier: Modifier = Modifier,
    navHostController: NavHostController // Controlador de navegação
){
    NavHost(
        navController = navHostController,
        startDestination = HomeRoutes.Login,
        modifier = modifier
    ){
        composable<HomeRoutes.Login> {
            LoginScreen(
                navigateToHomeScreen = {
                    navHostController.navigate(HomeRoutes.Home)
                },
                navigateToSigninScreen = {
                    navHostController.navigate(HomeRoutes.Signin)
                }
            )
        }

        composable<HomeRoutes.Signin> {
            SignInScreen(
                onBackPressed = {
                    navHostController.popBackStack()
                }
            )
        }

        composable<HomeRoutes.Home> {
            HomeScreen(
                onBackPressed = {
                    navHostController.popBackStack()
                },
                navigateToRouteScreen = {
                    navHostController.navigate(HomeRoutes.Routes)
                },
                navController = navHostController
            )
        }

        composable<HomeRoutes.Routes> {
            RoutesScreen(
                onBackPressed = {
                    navHostController.popBackStack()
                },
                navigateToRouteDetailsScreen = {
                    navHostController.navigate(HomeRoutes.RouteDetails)
                },
                navController = navHostController
            )
        }

        composable<HomeRoutes.RouteDetails> {
            RoutesDetailsScreen(
                onBackPressed = {
                    navHostController.popBackStack()
                },
                navController = navHostController
            )
        }

        composable<HomeRoutes.Map> {
            MapScreen(
                onBackPressed = {
                    navHostController.popBackStack()
                },
                navController = navHostController
            )
        }

        composable<HomeRoutes.Profile> {
            ProfileScreen(
                onBackPressed = {
                    navHostController.popBackStack()
                },
                navController = navHostController,
                onLogoutClick = {/*TODO*/}
            )
        }

    }
}