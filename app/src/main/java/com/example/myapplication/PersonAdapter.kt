package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

// The adapter is now correctly configured to accept a List<Person>.
class PersonAdapter(private val peopleList: List<Person>) :
    RecyclerView.Adapter<PersonAdapter.PersonViewHolder>() {

    class PersonViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val personImage: ImageView = view.findViewById(R.id.person_image)
        val personName: TextView = view.findViewById(R.id.person_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_person, parent, false)
        return PersonViewHolder(view)
    }

    override fun onBindViewHolder(holder: PersonViewHolder, position: Int) {
        val person = peopleList[position]
        holder.personName.text = person.name
        holder.personImage.setImageResource(person.imageResId)
    }

    override fun getItemCount() = peopleList.size
}
