package br.usp.esalq.caminhabilidade.domain.journey.model

data class SegmentCondition(
    val type: SegmentConditionType,
    val intensity: Double,
    val startPoint: JourneyPoint,
    val endPoint: JourneyPoint? = null,
)
