package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

// The ViewModel now uses the PersonRepository to get a List<Person>.
class PersonViewModel : ViewModel() {

    private val repository = PersonRepository()

    // This LiveData now correctly holds and exposes a List<Person>.
    private val _peopleItems = MutableLiveData<List<Person>>()
    val peopleItems: LiveData<List<Person>> = _peopleItems

    fun loadPeople() {
        _peopleItems.value = repository.getPeople()
    }
}
