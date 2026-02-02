package com.example.myapplication

// This repository creates and provides the list of Person objects.
class PersonRepository {

    fun getPeople(): List<Person> {
        // This list now correctly pairs the full names with their image files.
        // Make sure your images (dan.jpg, josh.jpg, etc.) are in the res/drawable folder.
        return listOf(
            Person("Daniel Padilla", R.drawable.dan),
            Person("Joshua Garcia", R.drawable.josh),
            Person("Dominic Villafuerte", R.drawable.doms),
            Person("Dwight Ramos", R.drawable.dwi)
        )
    }
}
