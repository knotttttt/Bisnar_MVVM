package com.example.myapplication

class FoodRepository {
    fun getBeginnerFoodList(): List<FoodItem> {
        // Now include the R.drawable reference for each item.
        return listOf(
            FoodItem("Apple", "Fruit", R.drawable.apple),
            FoodItem("Banana", "Fruit", R.drawable.banana),
            FoodItem("Chicken Breast", "Protein", R.drawable.chicken_breast),
        )
    }
}
