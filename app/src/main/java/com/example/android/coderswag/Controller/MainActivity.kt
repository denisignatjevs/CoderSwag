package com.example.android.coderswag.Controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.android.coderswag.Adapters.CategoryAdapter
import com.example.android.coderswag.Model.Category
import com.example.android.coderswag.R
import com.example.android.coderswag.Services.DataServices
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter : CategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // так создается адаптер
        adapter = CategoryAdapter(this, DataServices.categories)
        categoryListView.adapter = adapter

//        // делается Toast для каждого view, при нажатии показывается сообщение
//        categoryListView.setOnItemClickListener { adapterView, view, i, l ->
//            val category = DataServices.categories[i]
//            Toast.makeText(this, "You clicked on the ${category.title} cell", Toast.LENGTH_SHORT).show()
//        }
    }
}
