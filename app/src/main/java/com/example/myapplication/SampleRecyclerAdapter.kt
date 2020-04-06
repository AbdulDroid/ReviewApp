package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class SampleRecyclerAdapter(
    private val items: List<SampleData>,
    private val callBack: SampleInteractionCallBack
) : RecyclerView.Adapter<SampleViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SampleViewHolder =
        SampleViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.sample_list_item, parent, false)
        )


    override fun getItemCount(): Int  = items.size

    override fun onBindViewHolder(holder: SampleViewHolder, position: Int) {
        val item = items[position]
        holder.apply{
            bind(item)
            itemView.setOnClickListener {
                callBack.onClick(item)
            }
        }
    }

    /*interface SampleInteractionListener {

    }*/


}