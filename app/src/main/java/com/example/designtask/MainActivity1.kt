package com.example.designtask


import android.os.Bundle

import android.view.View
import androidx.appcompat.app.AppCompatActivity

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.designtask.Product
import com.example.designtask.ProductAdapter









class MainActivity1 : AppCompatActivity() {
    //a list to store all the products
    var productList: ArrayList<Product>? = null

    //the recyclerview
    var recyclerView: RecyclerView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //getting the recyclerview from xml
        recyclerView = findViewById<View>(R.id.recyclerView) as RecyclerView
        recyclerView!!.setHasFixedSize(true)
        recyclerView!!.layoutManager = LinearLayoutManager(this)

        //initializing the productlist
        productList = ArrayList()


        //adding some items to our list
        productList?.add(
            Product(
                1,
                "#JFHJD44556D",
                "14th May",
                "Amount",
                "$2.00",
                R.drawable.clock,
                 "Status",
               // accountInfo = "Account Info ",
                accounterName = "Lorem Ipsum",
                deductions ="Deductions",
                service = "Service",
                serviceValue = "$2.00",
                tds = "TDS",
                tdsValue ="$2.00",
                imps = "IMPS FEE",
                impsValue = "$2.00"

            )
        );








        //creating recyclerview adapter
        val adapter = ProductAdapter(this, productList!!)

        //setting adapter to recyclerview
        recyclerView!!.adapter = adapter
        adapter.notifyDataSetChanged();
    }
}