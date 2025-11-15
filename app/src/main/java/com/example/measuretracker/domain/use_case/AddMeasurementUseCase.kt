package com.example.measuretracker.domain.use_case

import com.example.domain.model.MeasurementRecord
import com.example.domain.repository.MeasurementRepository

class AddMeasurementUseCase(
    private val repository: MeasurementRepository
) {
    suspend operator fun invoke(record: MeasurementRecord) =
        repository.insertMeasurement(record)
}