package com.example.data.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface MeasurementDao {

    @Insert
    suspend fun insertMeasurement(measurement: MeasurementEntity): Long

    @Query("SELECT * FROM measurements ORDER BY date DESC")
    fun getAllMeasurements(): Flow<List<MeasurementEntity>>

    @Query("DELETE FROM measurements WHERE id = :id")
    suspend fun deleteMeasurement(id: Long)

    @Query("SELECT * FROM measurements WHERE id = :id")
    suspend fun getMeasurementById(id: Long): MeasurementEntity?

    @Update
    suspend fun updateMeasurement(measurement: MeasurementEntity)
}
