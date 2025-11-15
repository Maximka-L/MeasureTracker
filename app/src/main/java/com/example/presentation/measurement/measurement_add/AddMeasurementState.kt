package com.example.presentation.measurement.measurement_add

data class AddMeasurementState(
    val weight: String = "",
    val chest: String = "",
    val waist: String = "",
    val hips: String = "",
    val leftBicep: String = "",
    val rightBicep: String = "",
    val leftThigh: String = "",
    val rightThigh: String = "",
    val note: String = "",
    val isSaving: Boolean = false,
    val error: String? = null
)