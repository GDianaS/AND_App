package com.study.andancas.navigation.routes

import kotlinx.serialization.Serializable

sealed interface HomeRoutes {

    @Serializable
    data object Login : HomeRoutes

    @Serializable
    data object Signin : HomeRoutes

    @Serializable
    data object Home : HomeRoutes

    @Serializable
    data object Routes : HomeRoutes

    @Serializable
    data object RouteDetails : HomeRoutes

    @Serializable
    data object Profile : HomeRoutes

    @Serializable
    data object Map : HomeRoutes

}