package com.study.andancas.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import dev.jordond.compass.geocoder.Geocoder
import dev.jordond.compass.geocoder.MobileGeocoder
import dev.jordond.compass.geocoder.placeOrNull
import dev.jordond.compass.geolocation.Geolocator
import dev.jordond.compass.geolocation.GeolocatorResult
import dev.jordond.compass.geolocation.mobile


@Composable
fun getLocation(){
    val geoLocation = remember { Geolocator.mobile() }

    //Current location:
    LaunchedEffect(Unit){
        when (val result = geoLocation.current()){
            is GeolocatorResult.Success -> {
                println("LOCATION: ${result.data.coordinates}")

                val geocoder = MobileGeocoder()
                val place = geocoder.placeOrNull(result.data.coordinates)
                println("LOCATION NAME: ${place?.locality}")
                println("LOCATION NAME: ${place?.name}")           // Nome completo
                println("LOCATION CITY: ${place?.locality}")       // Cidade
                println("LOCATION COUNTRY: ${place?.country}")     // País
                println("LOCATION ADDRESS: ${place?.street}")      // Rua

            }

            is GeolocatorResult.Error -> when (result){
                is GeolocatorResult.NotSupported -> println("LOCATION ERROR: ${result.message}")
                is GeolocatorResult.NotFound -> println("LOCATION ERROR: ${result.message}")
                is GeolocatorResult.PermissionError -> println("LOCATION ERROR: ${result.message}")
                is GeolocatorResult.GeolocationFailed -> println("LOCATION ERROR: ${result.message}")
                else -> println("LOCATION ERROR: ${result.message}")
            }
        }
    }


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // TODO
    }
}

