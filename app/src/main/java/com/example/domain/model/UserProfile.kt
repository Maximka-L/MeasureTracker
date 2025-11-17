package com.example.domain.model

data class UserProfile(
    val name: String = "",
    val age: Int = 0,
    val height: Int = 0,
    val targetWeight: Float = 0f,
    val gender: String = "male"
)