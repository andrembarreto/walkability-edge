package br.usp.esalq.caminhabilidade.domain.journey.model

data class JourneyPoint(
    val latitude: Double,
    val longitude: Double,
    val altitude: Double,
    val timestamp: Long
)
