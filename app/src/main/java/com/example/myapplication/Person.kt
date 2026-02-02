package com.example.myapplication

import androidx.annotation.DrawableRes

// This class holds the data for one person: their name and a reference to their image.
data class Person(
    val name: String,
    @DrawableRes val imageResId: Int
)
