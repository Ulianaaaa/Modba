package com.example.mssko.retrofit.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Instance {
    private val BASE = "http://mskko2021.mad.hakta.pro/api/user/"
    private val retrofit = Retrofit.Builder().baseUrl(BASE)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    val apiServ = retrofit.create(Interface::class.java)
}