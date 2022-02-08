package com.example.mssko.retrofit.service

import com.example.mssko.retrofit.model.Feel
import com.example.mssko.retrofit.model.FeelMin
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface Interface {
    @POST("login")
    suspend fun getFeelings(@Body feelMin: FeelMin):Response<Feel>
}