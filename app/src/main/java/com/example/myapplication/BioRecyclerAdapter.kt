package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class BioRecyclerAdapter(private val items: List<BioItem>, private val callback: OnItemClick): RecyclerView.Adapter<BioViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BioViewHolder {
        return BioViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.bio_list_item, parent, false))
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: BioViewHolder, position: Int) {
        holder.apply {
            bind(items[position])
            itemView.setOnClickListener {
                callback.onClick()
            }
        }
    }

    interface OnItemClick {
        fun onClick()
    }
}

