package com.example.mssko.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mssko.R
import com.example.mssko.retrofit.model.FeelInData

class MyAdapter(val list : List<FeelInData>, val context : AppCompatActivity) : RecyclerView.Adapter<MyAdapter.Holder>() {
    inner class Holder(view:View) : RecyclerView.ViewHolder(view){
        val textt = itemView.findViewById<TextView>(R.id.textView)
        val imgg = itemView.findViewById<ImageView>(R.id.imageView)

        fun bind(item: FeelInData){
            textt.text = item.title
            Glide.with(context).load(item.image).into(imgg)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder =
        Holder(LayoutInflater.from(parent.context).inflate(R.layout.card_activity, parent, false))
    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size
}