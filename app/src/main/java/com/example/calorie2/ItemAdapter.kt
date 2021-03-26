package com.example.calorie2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.rv_item.view.*

class ItemAdapter(
    private val context: Context,
    private val images: List <Item>

    ) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

        class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view){

            fun bindView(items: Item) {
                itemView.image.setImageResource(items.imageSrc)
                itemView.item_name.text = items.item
                itemView.add_quantity.text = items.quantity
                itemView.item_calories.text = items.calories.toString()
            }

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)
            return ItemViewHolder(view)
        }

        override fun getItemCount(): Int = images.size


        override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
            holder.bindView(images[position])
            holder.itemView.setOnClickListener{
//                itemView.Total.text += images[position].calories.toString()
                var calCount = 0
                calCount+= images[position].calories
                var b = Bundle()
                b.putBoolean("isActive", true)
                intent.putExtras(b)
                startActivity(intent)

            }
        }

}