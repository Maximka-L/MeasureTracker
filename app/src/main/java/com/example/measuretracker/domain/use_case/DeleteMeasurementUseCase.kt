package com.example.measuretracker.domain.use_case

import com.example.domain.repository.MeasurementRepository
import javax.inject.Inject

class DeleteMeasurementUseCase @Inject constructor(
    private val repository: MeasurementRepository
) {
    suspend operator fun invoke(id: Int) = repository.deleteMeasurement(id)
}