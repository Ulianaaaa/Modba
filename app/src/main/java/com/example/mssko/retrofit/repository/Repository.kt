package com.example.mssko.retrofit.repository

import com.example.mssko.retrofit.model.Feel
import com.example.mssko.retrofit.model.FeelMin
import com.example.mssko.retrofit.service.Instance
import retrofit2.Response
import retrofit2.http.Body

class Repository {
    suspend fun getFeelings(@Body feelMin: FeelMin):Response<Feel>{
        return Instance.apiServ.getFeelings(feelMin)
    }
}