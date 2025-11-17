package com.example.measuretracker.domain.use_case

import com.example.domain.repository.MeasurementRepository
import javax.inject.Inject

class GetMeasurementsUseCase @Inject constructor(
    private val repository: MeasurementRepository
) {
    operator fun invoke() = repository.getAll()
}