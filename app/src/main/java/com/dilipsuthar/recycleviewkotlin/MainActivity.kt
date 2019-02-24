package com.dilipsuthar.recycleviewkotlin

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
