package com.example.presentation.measurement.measurement_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.measuretracker.domain.use_case.GetMeasurementsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MeasurementListViewModel @Inject constructor(
    private val getMeasurementsUseCase: GetMeasurementsUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(MeasurementListState())
    val state: StateFlow<MeasurementListState> = _state

    init {
        loadMeasurements()
    }

    private fun loadMeasurements() {
        viewModelScope.launch {
            getMeasurementsUseCase()
                .onEach { list ->
                    _state.value = _state.value.copy(
                        isLoading = false,
                        measurements = list,
                        error = null
                    )
                }
                .catch { e ->
                    _state.value = _state.value.copy(
                        isLoading = false,
                        error = e.message
                    )
                }
                .collect()
        }
    }
}