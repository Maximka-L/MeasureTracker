package com.example.measuretracker.domain.use_case

import com.example.domain.repository.MeasurementRepository

class GetMeasurementsUseCase(
    private val repository: MeasurementRepository
) {
    operator fun invoke() = repository.getAllMeasurements()
}