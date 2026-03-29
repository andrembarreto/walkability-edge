package br.usp.esalq.caminhabilidade.domain.journey.model

data class Event(
    val type: EventType,
    val point: JourneyPoint
)
