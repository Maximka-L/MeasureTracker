package com.example.presentation.measurement.measurement_add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.MeasurementRecord
import com.example.measuretracker.domain.use_case.AddMeasurementUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class AddMeasurementViewModel @Inject constructor(
    private val addMeasurementUseCase: AddMeasurementUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(AddMeasurementState())
    val state: StateFlow<AddMeasurementState> = _state

    // --- обработчики ввода ---

    fun onWeightChange(value: String) {
        _state.update { it.copy(weight = value) }
    }

    fun onChestChange(value: String) {
        _state.update { it.copy(chest = value) }
    }

    fun onWaistChange(value: String) {
        _state.update { it.copy(waist = value) }
    }

    fun onHipsChange(value: String) {
        _state.update { it.copy(hips = value) }
    }

    fun onLeftBicepChange(value: String) {
        _state.update { it.copy(leftBicep = value) }
    }

    fun onRightBicepChange(value: String) {
        _state.update { it.copy(rightBicep = value) }
    }

    fun onLeftThighChange(value: String) {
        _state.update { it.copy(leftThigh = value) }
    }

    fun onRightThighChange(value: String) {
        _state.update { it.copy(rightThigh = value) }
    }

    fun onNoteChange(value: String) {
        _state.update { it.copy(note = value) }
    }

    // --- сохранение ---

    fun saveMeasurement(onSuccess: () -> Unit) {
        viewModelScope.launch {
            _state.update { it.copy(isSaving = true, error = null) }
            try {
                val s = _state.value

                val record = MeasurementRecord(
                    id = 0,
                    date = System.currentTimeMillis(),
                    chest = s.chest.toFloatOrNull() ?: 0f,
                    waist = s.waist.toFloatOrNull() ?: 0f,
                    hips = s.hips.toFloatOrNull() ?: 0f,
                    leftBicep = s.leftBicep.toFloatOrNull() ?: 0f,
                    rightBicep = s.rightBicep.toFloatOrNull() ?: 0f,
                    leftThigh = s.leftThigh.toFloatOrNull() ?: 0f,
                    rightThigh = s.rightThigh.toFloatOrNull() ?: 0f,
                    weight = s.weight.toFloatOrNull(),
                    note = s.note
                )

                addMeasurementUseCase(record)
                onSuccess()
            } catch (e: Exception) {
                _state.update {
                    it.copy(
                        isSaving = false,
                        error = e.message ?: "Ошибка сохранения"
                    )
                }
            }
        }
    }
}