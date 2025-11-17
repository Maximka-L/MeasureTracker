package com.example.measuretracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.presentation.measurement.measurement_add.AddMeasurementScreen
import com.example.presentation.measurement.measurement_add.AddMeasurementViewModel
import com.example.presentation.measurement.measurement_list.MeasurementListScreen
import com.example.presentation.measurement.measurement_list.MeasurementListViewModel
import com.example.presentation.profile.ProfileScreen
import com.example.presentation.profile.ProfileViewModel
import dagger.hilt.android.AndroidEntryPoint

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

    NavHost(
        navController = navController,
        startDestination = "measurement_list"
    ) {

        // LIST
        composable("measurement_list") { backStackEntry ->
            val listVm: MeasurementListViewModel = hiltViewModel(backStackEntry)

            MeasurementListScreen(
                onAddClick = { navController.navigate("measurement_add") },
                onProfileClick = { navController.navigate("profile") },
                viewModel = listVm
            )
        }

        // ADD
        composable("measurement_add") { backStackEntry ->
            val addVm: AddMeasurementViewModel = hiltViewModel(backStackEntry)

            AddMeasurementScreen(
                onBack = { navController.popBackStack() },
                viewModel = addVm
            )
        }

        // PROFILE
        composable("profile") { backStackEntry ->
            val profileVm: ProfileViewModel = hiltViewModel(backStackEntry)

            ProfileScreen(viewModel = profileVm)
        }
    }
}
