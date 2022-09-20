package com.example.wishlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var items: MutableList<Item>
    lateinit var itemAdapter : ItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itemsRv = findViewById<RecyclerView>(R.id.wishlist)

        // make sure to initialize list of items
        items = ArrayList()
        itemAdapter = ItemAdapter(items)
        itemsRv.adapter = itemAdapter
        itemsRv.layoutManager = LinearLayoutManager(this)

        findViewById<Button>(R.id.submit).setOnClickListener {
            val name = findViewById<EditText>(R.id.name)
            val price = findViewById<EditText>(R.id.price)
            val url = findViewById<EditText>(R.id.url)

            // There is a bug with autolinking urls not showing when the textview is updated
            val newItem = Item(name.text.toString(), price.text.toString(), url.text.toString())
            items.add(newItem)
            itemAdapter.notifyItemInserted(items.size - 1)

            name.setText("")
            price.setText("")
            url.setText("")
        }
    }

}