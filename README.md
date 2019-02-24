# RecyclerView_Kotlin_demo
Here i simply make recyclerview app with kotlin so, you can understand how to add full recyclerview code in kotlin.

## 1. Make custom layout design for recyclerView items
``` <?xml version="1.0" encoding="utf-8"?>
<android.support.v7.widget.CardView
        xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:cardElevation="4dp"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        android:layout_marginVertical="8dp"
        app:cardCornerRadius="6dp">

    <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:background="#616C6F"
            android:orientation="vertical">

        <ImageView
                android:id="@+id/imageView"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                app:srcCompat="@drawable/oner"
                />

        <TextView
                android:id="@+id/textView"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_margin="4dp"
                android:text="Clicked at Studio"
                android:textAlignment="center"
                android:textColor="#fff"
                android:textSize="20dp" />

        <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_margin="4dp"
                android:orientation="horizontal">

            <Button
                    android:id="@+id/button"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_margin="2dp"
                    android:layout_weight="1"
                    android:background="#3498DB"
                    android:elevation="@dimen/cardview_default_elevation"
                    android:text="Like"
                    android:textColor="#fff" />

            <Button
                    android:id="@+id/button2"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_margin="2dp"
                    android:layout_weight="1"
                    android:background="#10A881"
                    android:text="Share"
                    android:textColor="#fff" />

            <Button
                    android:id="@+id/button3"
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:layout_margin="2dp"
                    android:layout_weight="1"
                    android:background="#E44236"
                    android:text="Subscribe"
                    android:textColor="#fff" />
        </LinearLayout>
    </LinearLayout>

</android.support.v7.widget.CardView>
```

## 2. Create a ```Model.kt``` class file
``` package com.dilipsuthar.recycleviewkotlin

data class Model(val imageRes: Int, val textView: String)
```

## 3. Create an ```AdapterExample.kt``` class file
``` package com.dilipsuthar.recycleviewkotlin

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
```
## 4. In your ```MainActivity.kt``` file add below code
``` package com.dilipsuthar.recycleviewkotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var layoutManage: RecyclerView.LayoutManager
    private lateinit var adapter: AdapterExample
    private var items = ArrayList<Model>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        generateFakeData()
        recyclerViewConfig()

        btnAdd.setOnClickListener {
            val pos = etAdd.text.toString().toInt()
            addCard(pos)
        }

        btnRemove.setOnClickListener {
            val pos = etRemove.text.toString().toInt()
            removeCard(pos)
        }

    }

    private fun generateFakeData() {
        items.add(Model(R.drawable.oner, "Clicked at Italy."))
        items.add(Model(R.drawable.twor, "Clicked at Rome."))
        items.add(Model(R.drawable.threer, "Clicked at Greece."))
        items.add(Model(R.drawable.fourr, "Clicked at Rome."))
        items.add(Model(R.drawable.fiver, "Clicked at USA"))
        items.add(Model(R.drawable.sixr, "Clicked at India"))
    }

    private fun recyclerViewConfig() {
        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.setHasFixedSize(true)
        layoutManage = LinearLayoutManager(this)
        adapter = AdapterExample(items)

        recyclerView.layoutManager = layoutManage
        recyclerView.adapter = adapter
    }

    private fun addCard(pos: Int) {
        items.add(pos, Model(R.drawable.sixr, "new added card"))
        adapter.notifyItemInserted(pos)
    }

    private fun removeCard(pos: Int) {
        items.removeAt(pos)
        adapter.notifyItemRemoved(pos)
    }
}
```

## Thank you.
