package com.example.measuretracker.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.measuretracker.presentation.measurement_add.AddMeasurementScreen
import com.example.measuretracker.measurement_add.AddMeasurementViewModel
import com.example.measuretracker.presentation.progress.ProgressScreen
import com.example.measuretracker.presentation.progress.ProgressViewModel

@Composable
fun AppNavHost(
    navController: NavHostController,
    addVM: AddMeasurementViewModel,
    progressVM: ProgressViewModel,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = "progress",
        modifier = modifier
    ) {
        composable("progress") {
            ProgressScreen(progressVM)
        }
        composable("add") {
            AddMeasurementScreen(addVM) {
                navController.popBackStack()
            }
        }
    }
}
