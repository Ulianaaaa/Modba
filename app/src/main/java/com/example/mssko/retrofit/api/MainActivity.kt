package com.example.mssko.retrofit.api

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mssko.MainActivity2
import com.example.mssko.R
import com.example.mssko.retrofit.model.FeelMin
import com.example.mssko.retrofit.repository.Repository
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel : MainViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



    }

    fun click(view: View) {

        val email = editTextTextEmailAddress.text.toString()
        val pass = editTextTextPassword.text.toString()

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
        viewModel = ViewModelProvider(this, viewModelFactory)[MainViewModel::class.java]
        viewModel.getFeelings(FeelMin(email, pass))
        viewModel.myResponse.observe(this, Observer { response ->
            Log.d("Response", response.body().toString())
            Log.d("Response", response.message().toString())
            Log.d("Response", response.code().toString())
        })

        val intent = Intent(this, MainActivity2::class.java)
        startActivity(intent)
    }
}