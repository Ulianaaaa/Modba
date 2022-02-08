package com.example.mssko.retrofit.api

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mssko.retrofit.model.Feel
import com.example.mssko.retrofit.model.FeelMin
import com.example.mssko.retrofit.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.http.Body

class MainViewModel(private val repository: Repository):ViewModel() {
    val myResponse : MutableLiveData<Response<Feel>> = MutableLiveData()
    fun getFeelings(@Body feelMin: FeelMin){
        viewModelScope.launch {
            val respone = repository.getFeelings(feelMin)
            myResponse.value = respone
        }
    }
}