package com.example.calorie2

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.makeText
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.rv_item.view.*
import org.w3c.dom.Text

class ItemAdapter(
    private val context: Context,
    private val images: List <Item>,
    private val listener: OnItemClickListener



) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

        inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener{

            fun bindView(items: Item) {
                itemView.image.setImageResource(items.imageSrc)
                itemView.item_name.text = items.item
                itemView.add_quantity.text = items.quantity
                itemView.item_calories.text = items.calories.toString()
            }
            init {
                itemView.setOnClickListener(this)
            }

            override fun onClick(v: View?) {
                val position = adapterPosition
                if (position!= RecyclerView.NO_POSITION) {
                    listener.onItemClick(position)
                }
            }
        }
    interface OnItemClickListener{
        fun onItemClick(position: Int)
    }


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)
            return ItemViewHolder(view)
        }

        override fun getItemCount(): Int = images.size


        override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
            holder.bindView(images[position])

        }

}