package com.study.andancas.features.map

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable

data class LocationSpot(
    val name: String,
    val address: String,
    val latitude: Double,
    val longitude: Double,
    val description: String
)

@Composable
fun getSampleSpots(): List<LocationSpot> {
    return listOf(
        LocationSpot(
            name = "Orla da Vila de Alter",
            address = "Alter do Chão, Santarém - PA",
            latitude = -2.5044,
            longitude = -54.9491,
            description = "Praia paradisíaca com águas cristalinas e barracas."
        ),
        LocationSpot(
            name = "Praia do Pindobal",
            address = "Rod. Everaldo Martins, km 20 - Santarém",
            latitude = -2.4891,
            longitude = -54.8753,
            description = "Praia de rio com areia branca, muito procurada por turistas."
        ),
        LocationSpot(
            name = "Catedral Metropolitana",
            address = "Praça São Sebastião, Santarém - PA",
            latitude = -2.4391,
            longitude = -54.7079,
            description = "Importante construção histórica e religiosa da cidade."
        )
    )
}


