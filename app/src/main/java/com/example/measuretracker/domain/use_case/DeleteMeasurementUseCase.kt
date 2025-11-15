package com.example.measuretracker.domain.use_case

import com.example.domain.repository.MeasurementRepository

class DeleteMeasurementUseCase(
    private val repository: MeasurementRepository
) {
    suspend operator fun invoke(id: Long) =
        repository.deleteMeasurement(id)
}