package com.example.measuretracker.domain.use_case

import com.example.domain.repository.MeasurementRepository
import com.example.domain.model.MeasurementRecord
import javax.inject.Inject

class AddMeasurementUseCase(
    private val repository: MeasurementRepository
) {
    suspend operator fun invoke(record: MeasurementRecord): Long {
        return repository.addMeasurement(record)
    }
}