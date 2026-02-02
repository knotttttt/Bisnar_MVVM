package com.example.myapplication

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

// The MainActivity acts as the View.
class MainActivity : AppCompatActivity() {

    private val foodViewModel: FoodViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val recyclerView = RecyclerView(this)
        // You need to assign an ID to use findViewById later
        recyclerView.id = View.generateViewId()
        setContentView(recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)

        foodViewModel.foodItems.observe(this) { foodList ->
            recyclerView.adapter = FoodAdapter(foodList)
        }

        foodViewModel.loadFoodItems()

        ViewCompat.setOnApplyWindowInsetsListener(recyclerView) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
