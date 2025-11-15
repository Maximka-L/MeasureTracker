package com.example.domain.repository

import com.example.domain.model.MeasurementRecord
import kotlinx.coroutines.flow.Flow

interface MeasurementRepository {

    fun getAllMeasurements(): Flow<List<MeasurementRecord>>

    suspend fun insertMeasurement(record: MeasurementRecord): Long

    suspend fun getMeasurementById(id: Long): MeasurementRecord?

    suspend fun deleteMeasurement(id: Long)

    suspend fun updateMeasurement(record: MeasurementRecord)
}
