package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FoodAdapter(private val foodList: List<FoodItem>) :
    RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {

    // The ViewHolder now holds references to the ImageView and TextViews from your custom layout.
    class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imageView: ImageView = itemView.findViewById(R.id.food_image)
        private val nameTextView: TextView = itemView.findViewById(R.id.food_name)
        private val categoryTextView: TextView = itemView.findViewById(R.id.food_category)

        fun bind(foodItem: FoodItem) {
            imageView.setImageResource(foodItem.imageRes)
            nameTextView.text = foodItem.name
            categoryTextView.text = foodItem.category
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        // Inflate your new custom layout instead of the default one.
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_food, parent, false)
        return FoodViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        holder.bind(foodList[position])
    }

    override fun getItemCount() = foodList.size
}
