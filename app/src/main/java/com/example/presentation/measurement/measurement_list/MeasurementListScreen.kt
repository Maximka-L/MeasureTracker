@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.presentation.measurement.measurement_list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SwipeToDismissBox
import androidx.compose.material3.SwipeToDismissBoxValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberSwipeToDismissBoxState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.domain.model.MeasurementRecord
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
fun MeasurementListScreen(
    onAddClick: () -> Unit,
    onProfileClick: () -> Unit,
    viewModel: MeasurementListViewModel
) {
    val state = viewModel.state.collectAsState().value

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text("Измерения тела") },
                actions = {
                    IconButton(onClick = onProfileClick) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Профиль"
                        )
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = onAddClick) {
                Text("+")
            }
        }
    ) { padding ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {

            when {
                state.isLoading -> {
                    CircularProgressIndicator(
                        modifier = Modifier.align(Alignment.Center)
                    )
                }

                state.error != null -> {
                    Text(
                        text = "Ошибка: ${state.error}",
                        modifier = Modifier.align(Alignment.Center)
                    )
                }

                state.measurements.isEmpty() -> {
                    Text(
                        text = "Нет данных. Нажмите + чтобы добавить измерение.",
                        modifier = Modifier.align(Alignment.Center)
                    )
                }

                else -> {
                    LazyColumn {
                        items(
                            items = state.measurements,
                            key = { it.id }
                        ) { item ->

                            val dismissState = rememberSwipeToDismissBoxState(
                                confirmValueChange = { value ->
                                    if (value == SwipeToDismissBoxValue.EndToStart) {
                                        viewModel.deleteMeasurement(item.id)
                                        true
                                    } else false
                                }
                            )

                            SwipeToDismissBox(
                                state = dismissState,
                                backgroundContent = {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .padding(10.dp),
                                        contentAlignment = Alignment.CenterEnd
                                    ) {
                                        Text("Удалить", color = Color.Red)
                                    }
                                },
                                content = {
                                    MeasurementItemCard(item)
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun MeasurementItemCard(item: MeasurementRecord) {

    val formattedDate = remember(item.date) {
        val sdf = SimpleDateFormat("dd.MM.yyyy HH:mm", Locale.getDefault())
        sdf.format(Date(item.date))
    }

    androidx.compose.material3.Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text("Дата: $formattedDate")
            Text("Вес: ${item.weight?.toString() ?: "-"} кг")
            Text("Грудь: ${item.chest} см")
            Text("Талия: ${item.waist} см")
            Text("Бёдра: ${item.hips} см")
            Text("Левый бицепс: ${item.leftBicep} см")
            Text("Правый бицепс: ${item.rightBicep} см")
            Text("Левое бедро: ${item.leftThigh} см")
            Text("Правое бедро: ${item.rightThigh} см")

            if (!item.note.isNullOrBlank()) {
                Text("Заметка: ${item.note}")
            }
        }
    }
}
