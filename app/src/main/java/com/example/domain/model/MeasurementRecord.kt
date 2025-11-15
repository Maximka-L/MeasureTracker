package com.example.domain.model

data class MeasurementRecord(
    val id: Long = 0,
    val date: Long,
    val chest: Float,
    val waist: Float,
    val hips: Float,
    val leftBicep: Float,
    val rightBicep: Float,
    val leftThigh: Float,
    val rightThigh: Float,
    val weight: Float?,
    val note: String
)