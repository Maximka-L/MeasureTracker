package com.example.measuretracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.AndroidEntryPoint
import com.example.presentation.measurement.measurement_list.MeasurementListScreen
import com.example.presentation.measurement.measurement_list.MeasurementListViewModel
import com.example.presentation.measurement.measurement_add.AddMeasurementScreen
import com.example.presentation.measurement.measurement_add.AddMeasurementViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MeasureTrackerApp()
        }
    }
}

@Composable
fun MeasureTrackerApp() {
    val navController = rememberNavController()

    // Создаём VM один раз на уровне Activity (это точно безопасно)
    val listViewModel: MeasurementListViewModel = hiltViewModel()
    val addViewModel: AddMeasurementViewModel = hiltViewModel()

    NavHost(
        navController = navController,
        startDestination = "measurement_list"
    ) {
        composable("measurement_list") {
            MeasurementListScreen(
                onAddClick = { navController.navigate("measurement_add") },
                viewModel = listViewModel
            )
        }

        composable("measurement_add") {
            AddMeasurementScreen(
                onBack = { navController.popBackStack() },
                viewModel = addViewModel
            )
        }
    }
}

