package com.example.android.coderswag.Controller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.android.coderswag.Model.Category
import com.example.android.coderswag.R
import com.example.android.coderswag.Services.DataServices
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter : ArrayAdapter<Category>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // так создается адаптер
        adapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1,
            DataServices.categories)
        categoryListView.adapter = adapter

    }
}
