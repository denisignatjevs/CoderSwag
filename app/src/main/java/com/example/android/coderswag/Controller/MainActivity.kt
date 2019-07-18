package com.example.android.coderswag.Controller

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.android.coderswag.Adapters.CategoryAdapter
import com.example.android.coderswag.Adapters.CategoryRecycleAdapter
import com.example.android.coderswag.Model.Category
import com.example.android.coderswag.R
import com.example.android.coderswag.Services.DataServices
import com.example.android.coderswag.Utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var adapter : CategoryRecycleAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // так создается адаптер
        adapter = CategoryRecycleAdapter(this, DataServices.categories) {category ->
            val productIntent = Intent(this, ProductActivity::class.java)
            productIntent.putExtra(EXTRA_CATEGORY, category.title) // this is how we add our extras that we're able to pass around from activity to activity
            startActivity(productIntent) // так создается переход на другую активити
        }
        categoryListView.adapter = adapter // говорим Лист Вью, кого слушать

//        // делается Toast для каждого view, при нажатии показывается сообщение
//        categoryListView.setOnItemClickListener { adapterView, view, i, l ->
//            val category = DataServices.categories[i]
//            Toast.makeText(this, "You clicked on the ${category.title} cell", Toast.LENGTH_SHORT).show()
//        }

        val layoutManager = LinearLayoutManager(this)
        categoryListView.layoutManager = layoutManager
        categoryListView.setHasFixedSize(true)
    }
}
