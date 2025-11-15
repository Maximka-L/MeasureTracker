package com.example.data.local.database
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "measurements")
data class MeasurementEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val weight: Float,
    val chest: Float,
    val waist: Float,
    val hips: Float,
    val leftBicep: Float,
    val rightBicep: Float,
    val leftThigh: Float,
    val rightThigh: Float,
    val note: String?,
    val date: Long
)
