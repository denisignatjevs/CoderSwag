package com.example.android.coderswag.Controller

import android.content.res.Configuration
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import com.example.android.coderswag.Adapters.ProductsAdapter
import com.example.android.coderswag.R
import com.example.android.coderswag.Services.DataServices
import com.example.android.coderswag.Utilities.EXTRA_CATEGORY
import kotlinx.android.synthetic.main.activity_product.*

class ProductActivity : AppCompatActivity() {

    lateinit var adapter : ProductsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product)

        val categoryType = intent.getStringExtra(EXTRA_CATEGORY)
        adapter = ProductsAdapter(this, DataServices.getProducts(categoryType))

        var spanCount = 2
        val orientation = resources.configuration.orientation // return integer num 1 or 2
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            spanCount = 3 //указывает, сколько в одной колонне будет показывать изображений
        }

        val screenSize = resources.configuration.screenWidthDp
        if (screenSize > 720) {
            spanCount = 3
        }
        
        val layoutManager = GridLayoutManager(this, spanCount)
        productsListView.layoutManager = layoutManager
        productsListView.adapter = adapter
    }
}
