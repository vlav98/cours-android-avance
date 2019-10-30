package com.example.projetkotlin

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ExempleAdapter(private val list: Array<String>):
    RecyclerView.Adapter<ExempleAdapter.ExampleViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int):
            ExampleViewHolder {
        val viewHolder = LayoutInflater.from(parent.context).inflate(R.layout.layout_exemple, parent, false)
        return ExampleViewHolder(viewHolder)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) = holder.bind(list[position])

    class ExampleViewHolder(itemView: View):
        RecyclerView.ViewHolder(itemView) {
        private val textView: TextView = itemView.findViewById(R.id.textView)

        fun bind(text: String){
            textView.text = text
        }
    }
}