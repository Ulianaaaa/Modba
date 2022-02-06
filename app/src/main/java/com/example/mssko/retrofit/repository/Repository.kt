package com.example.mssko.retrofit.repository

import com.example.mssko.retrofit.model.Feel
import com.example.mssko.retrofit.service.Instance
import retrofit2.Response

class Repository {
    suspend fun getFeelings():Response<Feel>{
        return Instance.apiServ.getFeelings()
    }
}