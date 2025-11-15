package com.example.presentation.measurement.measurement_list

import com.example.domain.model.MeasurementRecord

data class MeasurementListState(
    val isLoading: Boolean = false,
    val measurements: List<MeasurementRecord> = emptyList(),
    val error: String? = null
)