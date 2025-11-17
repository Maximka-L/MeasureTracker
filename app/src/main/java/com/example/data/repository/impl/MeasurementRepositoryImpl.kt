package com.example.data.repository.impl

import com.example.data.local.database.MeasurementDao
import com.example.data.local.database.MeasurementEntity
import com.example.domain.model.MeasurementRecord
import com.example.domain.repository.MeasurementRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MeasurementRepositoryImpl @Inject constructor(
    private val dao: MeasurementDao
) : MeasurementRepository {

    override suspend fun addMeasurement(record: MeasurementRecord) {
        dao.insertMeasurement(
            MeasurementEntity(
                id = record.id.toLong(),
                date = record.date,
                weight = record.weight,
                chest = record.chest,
                waist = record.waist,
                hips = record.hips,
                leftBicep = record.leftBicep,
                rightBicep = record.rightBicep,
                leftThigh = record.leftThigh,
                rightThigh = record.rightThigh,
                note = record.note ?: ""
            )
        )
    }

    override fun getAll(): Flow<List<MeasurementRecord>> {
        return dao.getAllMeasurements().map { list ->
            list.map { entity ->
                MeasurementRecord(
                    id = entity.id.toInt(),
                    date = entity.date,
                    weight = entity.weight,
                    chest = entity.chest,
                    waist = entity.waist,
                    hips = entity.hips,
                    leftBicep = entity.leftBicep,
                    rightBicep = entity.rightBicep,
                    leftThigh = entity.leftThigh,
                    rightThigh = entity.rightThigh,
                    note = entity.note
                )
            }
        }
    }

    override suspend fun deleteMeasurement(id: Int) {
        dao.deleteMeasurement(id.toLong())
    }

    override suspend fun getById(id: Int): MeasurementRecord? {
        val entity = dao.getMeasurementById(id.toLong()) ?: return null

        return MeasurementRecord(
            id = entity.id.toInt(),
            date = entity.date,
            weight = entity.weight,
            chest = entity.chest,
            waist = entity.waist,
            hips = entity.hips,
            leftBicep = entity.leftBicep,
            rightBicep = entity.rightBicep,
            leftThigh = entity.leftThigh,
            rightThigh = entity.rightThigh,
            note = entity.note
        )
    }

    override suspend fun updateMeasurement(record: MeasurementRecord) {
        dao.updateMeasurement(
            MeasurementEntity(
                id = record.id.toLong(),
                date = record.date,
                weight = record.weight,
                chest = record.chest,
                waist = record.waist,
                hips = record.hips,
                leftBicep = record.leftBicep,
                rightBicep = record.rightBicep,
                leftThigh = record.leftThigh,
                rightThigh = record.rightThigh,
                note = record.note ?: ""
            )
        )
    }
}
