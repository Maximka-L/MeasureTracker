package com.example.data.local.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface MeasurementDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertMeasurement(measurement: MeasurementEntity): Long

    @Query("SELECT * FROM measurement_records ORDER BY date DESC")
    fun getAllMeasurements(): Flow<List<MeasurementEntity>>

    @Query("DELETE FROM measurement_records WHERE id = :id")
    suspend fun deleteMeasurement(id: Long)

    @Query("SELECT * FROM measurement_records WHERE id = :id LIMIT 1")
    suspend fun getMeasurementById(id: Long): MeasurementEntity?

    @Update
    suspend fun updateMeasurement(measurement: MeasurementEntity)
}
