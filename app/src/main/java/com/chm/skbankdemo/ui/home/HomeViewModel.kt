package com.chm.skbankdemo.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chm.skbankdemo.api.ApiResponse
import com.chm.skbankdemo.api.safeApiCall
import com.chm.skbankdemo.api.model.ApiResult
import com.chm.skbankdemo.api.model.Zoo
import kotlinx.coroutines.launch

class HomeViewModel(
    private var repository: HomeRepository
) : ViewModel() {

    val zooResponse: MutableLiveData<ApiResult> =
        MutableLiveData<ApiResult>()

    val apiFailResponse: MutableLiveData<String> = MutableLiveData<String>()

    init {
        getZooInfo()
    }

    fun getZooInfo() {
        viewModelScope.launch {
            when (val response = safeApiCall { repository.getZooInfo() }) {
                is ApiResponse.Success -> {
                    response.data.let {
                        zooResponse.value = it
                    }
                }
                is ApiResponse.Fail -> {
                    apiFailResponse.value = response.message ?: response.throwable?.message
                }
            }
        }
    }
}