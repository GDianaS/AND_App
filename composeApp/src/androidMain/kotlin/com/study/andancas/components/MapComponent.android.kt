package com.study.andancas.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberMarkerState
import com.study.andancas.features.map.LocationSpot
import com.study.andancas.features.map.getSampleSpots

@Composable
actual fun MapComponent(
) {
    val spots = getSampleSpots()
    val defaultLocation = LatLng(-2.4430, -54.7077) // Posição inicial do mapa (Santarém)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(defaultLocation, 12f)
    }

    // Criando um mapa
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 45.dp)
    ) {
        GoogleMap(
            modifier = Modifier.fillMaxSize(),
            cameraPositionState = cameraPositionState
        ) {
            spots.forEach { spot ->
                Marker(
                    state = rememberMarkerState(position = LatLng(spot.latitude, spot.longitude)),
                    title = spot.name,
                    snippet = spot.description
                )
            }
        }
    }
}

