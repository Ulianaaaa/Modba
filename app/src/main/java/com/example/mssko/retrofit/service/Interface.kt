package com.example.mssko.retrofit.service

import com.example.mssko.retrofit.model.Feel
import retrofit2.Response
import retrofit2.http.GET

interface Interface {
    @GET("feelings")
    suspend fun getFeelings():Response<Feel>
}