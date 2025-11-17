package com.example.domain.repository

import com.example.domain.model.MeasurementRecord
import kotlinx.coroutines.flow.Flow

interface MeasurementRepository {

    suspend fun addMeasurement(record: MeasurementRecord)

    fun getAll(): Flow<List<MeasurementRecord>>

    suspend fun deleteMeasurement(id: Int)

    suspend fun getById(id: Int): MeasurementRecord?

    suspend fun updateMeasurement(record: MeasurementRecord)
}