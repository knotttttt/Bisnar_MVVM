package com.example.myapplication

import androidx.annotation.DrawableRes

// Add an 'imageRes' property to hold the drawable resource ID.
// Using @DrawableRes is good practice to ensure it's a valid drawable.
data class FoodItem(
    val name: String,
    val category: String,
    @DrawableRes val imageRes: Int // <-- ADD THIS LINE
)
