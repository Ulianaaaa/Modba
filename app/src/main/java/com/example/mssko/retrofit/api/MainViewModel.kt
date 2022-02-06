package com.example.mssko.retrofit.api

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mssko.retrofit.model.Feel
import com.example.mssko.retrofit.repository.Repository
import kotlinx.coroutines.launch
import retrofit2.Response

class MainViewModel(private val repository: Repository):ViewModel() {
    val myResponse : MutableLiveData<Response<Feel>> = MutableLiveData()
    fun getFeelings(){
        viewModelScope.launch {
            val respone = repository.getFeelings()
            myResponse.value = respone
        }
    }
}