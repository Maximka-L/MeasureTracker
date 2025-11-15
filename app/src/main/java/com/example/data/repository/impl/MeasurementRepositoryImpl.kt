import com.example.data.local.database.MeasurementDao
import com.example.data.mapper.toDomain
import com.example.data.mapper.toEntity
import com.example.domain.model.MeasurementRecord
import com.example.domain.repository.MeasurementRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MeasurementRepositoryImpl(
    private val dao: MeasurementDao
) : MeasurementRepository {

    override fun getAllMeasurements(): Flow<List<MeasurementRecord>> {
        return dao.getAllMeasurements().map { list ->
            list.map { it.toDomain() }
        }
    }

    override suspend fun insertMeasurement(record: MeasurementRecord): Long {
        return dao.insertMeasurement(record.toEntity())
    }

    override suspend fun getMeasurementById(id: Long): MeasurementRecord? {
        return dao.getMeasurementById(id)?.toDomain()
    }

    override suspend fun deleteMeasurement(id: Long) {
        dao.deleteMeasurement(id)
    }

    override suspend fun updateMeasurement(record: MeasurementRecord) {
        dao.updateMeasurement(record.toEntity())
    }
}