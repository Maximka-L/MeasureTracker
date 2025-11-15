package com.example.measuretracker.navigation

sealed class NavRoute(val route: String) {
    object MeasurementList : NavRoute("measurement_list")
    object AddMeasurement : NavRoute("add_measurement")
    object Progress : NavRoute("progress")
}
