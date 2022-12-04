package com.example.pokedex2.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pokedex2.R
import com.example.pokedex2.model.listEntries

class ItemAdapter(private val context: Context, private val dataset: List<listEntries>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>()  {
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view){
        val textView : TextView = view.findViewById(R.id.pokemon_name)
        val imageView : ImageView = view.findViewById(R.id.pokemon_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text =  context.resources.getString(item.stringResourceId)
        holder.imageView.setImageResource(item.imageResourceId)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

}