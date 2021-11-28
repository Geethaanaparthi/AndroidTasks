package com.example.designtask

import android.os.Bundle
import com.example.designtask.R
import com.example.designtask.MyAdapter
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.designtask.model.ProductInfo
import com.example.designtask.retrofit.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class MainActivity : AppCompatActivity() {
    var mToolbar: Toolbar? = null
    var mRecyclerView: RecyclerView? = null
    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        mToolbar = findViewById(R.id.toolbar)
       // mToolbar.setTitle(getResources().getString(R.string.app_name))
        mRecyclerView = findViewById(R.id.recyclerView)
        val mGridLayoutManager = GridLayoutManager(this@MainActivity, 2)
        mRecyclerView?.setLayoutManager(mGridLayoutManager)
        superHeroes()
    }

    private fun superHeroes() {
        val call: Call<List<ProductInfo>> = RetrofitClient.getInstance().getMyApi().getProducts()
        call.enqueue(object : Callback<List<ProductInfo>> {

            override fun onResponse(
                call: Call<List<ProductInfo>>,
                response: Response<List<ProductInfo>>
            ) {
                val myAdapter = MyAdapter(this@MainActivity, response.body()!!)
                mRecyclerView!!.adapter = myAdapter
                myAdapter.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<ProductInfo>>, t: Throwable) {
            }
        })
    }
}




