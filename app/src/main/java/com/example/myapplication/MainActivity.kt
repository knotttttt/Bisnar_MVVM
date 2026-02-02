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

class MainActivity : AppCompatActivity() {

    private val viewModel: PersonViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        // Set the content view to your new layout file
        setContentView(R.layout.activity_main)

        // Find the RecyclerView from the layout
        val recyclerView: RecyclerView = findViewById(R.id.people_recyclerview)
        recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.peopleItems.observe(this) { peopleList ->
            recyclerView.adapter = PersonAdapter(peopleList)
        }

        viewModel.loadPeople()

        // Apply window insets to the root LinearLayout
        val mainLayout: View = findViewById(R.id.main_layout) // Get the root layout
        ViewCompat.setOnApplyWindowInsetsListener(mainLayout) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
