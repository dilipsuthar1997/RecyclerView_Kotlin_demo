package com.dilipsuthar.recycleviewkotlin

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

class AdapterExample(private val items: ArrayList<Model>) : RecyclerView.Adapter<AdapterExample.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val textView = itemView.findViewById<TextView>(R.id.textView)
        val imageView = itemView.findViewById<ImageView>(R.id.imageView)

    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): MyViewHolder {

        val view = LayoutInflater.from(p0.context).inflate(R.layout.item_example, p0, false)

        return MyViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: MyViewHolder, pos: Int) {
        val currentItem = items[pos]

        holder.textView.text = currentItem.textView
        holder.imageView.setImageResource(currentItem.imageRes)

    }

}