import androidx.compose.ui.text.font.FontVariation.weight
import com.example.data.local.database.MeasurementEntity
import com.example.domain.model.MeasurementRecord

private fun MeasurementEntity.toDomain() = MeasurementRecord(
    id = id,
    weight = weight ?: 0f,
    chest = chest ?: 0f,
    waist = waist ?: 0f,
    hips = hips ?: 0f,
    leftBicep = leftBicep ?: 0f,
    rightBicep = rightBicep ?: 0f,
    leftThigh = leftThigh ?: 0f,
    rightThigh = rightThigh ?: 0f,
    note = note ?: "",
    date = date
)

private fun MeasurementRecord.toEntity() = MeasurementEntity(
    id = id,
    weight = weight!! ,
            chest = chest,
    waist = waist,
    hips = hips,
    leftBicep = leftBicep,
    rightBicep = rightBicep,
    leftThigh = leftThigh,
    rightThigh = rightThigh,
    note = note,
    date = date
)