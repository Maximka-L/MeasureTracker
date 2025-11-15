package com.example.measuretracker.domain.use_case

import com.example.domain.repository.MeasurementRepository
import com.example.domain.model.MeasurementRecord

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllMeasurementsUseCase(
    private val repository: MeasurementRepository
) {
    operator fun invoke() = repository.getAllMeasurements()
}