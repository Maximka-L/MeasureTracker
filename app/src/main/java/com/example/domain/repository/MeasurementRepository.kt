package com.example.domain.repository

import com.example.domain.model.MeasurementRecord
import kotlinx.coroutines.flow.Flow

interface MeasurementRepository {
    fun getAllMeasurements(): Flow<List<MeasurementRecord>>
    suspend fun getMeasurementById(id: Long): MeasurementRecord?
    suspend fun addMeasurement(record: MeasurementRecord): Long
    suspend fun updateMeasurement(record: MeasurementRecord)
    suspend fun deleteMeasurement(id: Long)
}
