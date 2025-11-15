package com.example.measuretracker.presentation.progress

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProgressChart(data: List<Float>) {
    Box(modifier = Modifier.size(200.dp)) {
        Text("Тут будет график (${data.size} точек)")
    }
}
