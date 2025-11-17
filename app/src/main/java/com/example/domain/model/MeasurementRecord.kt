package com.example.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "measurement")
data class MeasurementRecord(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val date: Long,
    val weight: Float?,
    val chest: Float,
    val waist: Float,
    val hips: Float,
    val leftBicep: Float,
    val rightBicep: Float,
    val leftThigh: Float,
    val rightThigh: Float,
    val note: String?
)