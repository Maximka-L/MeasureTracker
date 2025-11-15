package com.example.measuretracker.domain.use_case

import com.example.domain.model.MeasurementRecord
import com.example.domain.repository.MeasurementRepository

class UpdateMeasurementUseCase(
    private val repository: MeasurementRepository
) {
    suspend operator fun invoke(record: MeasurementRecord) =
        repository.updateMeasurement(record)
}