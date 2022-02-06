package com.example.mssko.retrofit.api

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mssko.R
import com.example.mssko.adapter.MyAdapter
import com.example.mssko.retrofit.model.FeelInData
import com.example.mssko.retrofit.repository.Repository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel : MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
        viewModel.getFeelings()
        viewModel.myResponse.observe(this, Observer { response ->
            Log.d("Response", response.body()!!.data.toString())

            val res = response.body()?.data as List<FeelInData>
            val adapter = MyAdapter(res, this)
            val layoutManager= LinearLayoutManager(this)
            layoutManager.orientation = LinearLayoutManager.HORIZONTAL
            reccucl.adapter = adapter
            reccucl.layoutManager = LinearLayoutManager(this)

        })


    }
}