package com.example.measuretracker.presentation.measurement_add

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.measuretracker.measurement_add.AddMeasurementViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddMeasurementScreen(
    viewModel: AddMeasurementViewModel,
    onBack: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Add Measurement") })
        }
    ) { padding ->
        Column(modifier = Modifier.padding(padding).padding(16.dp)) {
            Text("Здесь будет форма для добавления измерения")
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { onBack() }) {
                Text("Назад")
            }
        }
    }
}
