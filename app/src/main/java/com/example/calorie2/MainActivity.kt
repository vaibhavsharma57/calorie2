package com.example.calorie2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ItemAdapter.OnItemClickListener {

    private val itemsList = ArrayList<Item>()
    var total : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupData()
        initRV()
    }

    override fun onItemClick(position: Int) {

        total += itemsList[position].calories
        Toast.makeText(this,total.toString(),Toast.LENGTH_SHORT).show()
    }

    private fun setupData(){
            val item1 = Item("Milk", R.drawable.milk, 22 , "Add 50ml")
            val item2 = Item("Egg", R.drawable.egg, 75 , "Add 1")
            val item3 = Item("Potato", R.drawable.potato, 100, "Add 100g")
            val item4 = Item("Banana", R.drawable.banana, 100, "Add 100g")
            val item5 = Item("Bread", R.drawable.bread, 125, "Add 50g")
            val item6 = Item("Chicken", R.drawable.chicken, 250, "Add 100g")
            val item7 = Item("Fish", R.drawable.fish, 200, "Add 100g")
            val item8 = Item("Lentils", R.drawable.lentils, 50, "Add 50g")
            val item9 = Item("Oats", R.drawable.oats, 175, "Add 50g")
            val item10 = Item("Paneer", R.drawable.paneer, 150, "Add 50g")
            val item11 = Item("Rice", R.drawable.rice, 75, "Add 50g")
            val item12 = Item("Tomato", R.drawable.tomato, 50, "Add 100g")

            itemsList.add(item1)
            itemsList.add(item2)
            itemsList.add(item3)
            itemsList.add(item4)
            itemsList.add(item5)
            itemsList.add(item6)
            itemsList.add(item7)
            itemsList.add(item8)
            itemsList.add(item9)
            itemsList.add(item10)
            itemsList.add(item11)
            itemsList.add(item12)

        }


        private fun initRV(){
            itemRecyclerView.layoutManager = LinearLayoutManager(this)
            val mAdapter = ItemAdapter(this, itemsList,this)
            itemRecyclerView.adapter = mAdapter
            mAdapter.notifyDataSetChanged()
        }


//    override fun onItemClick(items: Item) {
//
//        var count = findViewById<TextView>(R.id.Total)
//        var calCount = 0
//
//        calCount+= items.calories
//
//        count.text = calCount.toString()
//        Toast.makeText(this, calCount , Toast.LENGTH_SHORT).show()
//    }


}