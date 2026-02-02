package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

// It holds and prepares the data for the UI (the View).
class FoodViewModel : ViewModel() {
    private val repository = FoodRepository()

    private val _foodItems = MutableLiveData<List<FoodItem>>()
    val foodItems: LiveData<List<FoodItem>> = _foodItems

    fun loadFoodItems() {
        val data = repository.getBeginnerFoodList()
        _foodItems.postValue(data)
    }
}
    