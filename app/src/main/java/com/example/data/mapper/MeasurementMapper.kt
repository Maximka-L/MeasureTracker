package com.example.data.mapper

import com.example.data.local.database.MeasurementEntity
import com.example.domain.model.MeasurementRecord

fun MeasurementEntity.toDomain(): MeasurementRecord =
    MeasurementRecord(
        id = id,
        date = date,
        chest = chest,
        waist = waist,
        hips = hips,
        leftBicep = leftBicep,
        rightBicep = rightBicep,
        leftThigh = leftThigh,
        rightThigh = rightThigh,
        weight = weight,
        note = note
    )

fun MeasurementRecord.toEntity(): MeasurementEntity =
    MeasurementEntity(
        id = id,
        date = date,
        chest = chest,
        waist = waist,
        hips = hips,
        leftBicep = leftBicep,
        rightBicep = rightBicep,
        leftThigh = leftThigh,
        rightThigh = rightThigh,
        weight = weight,
        note = note
    )