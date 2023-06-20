package com.chm.skbankdemo.ui.home

import com.chm.skbankdemo.api.ApiService
import com.chm.skbankdemo.api.model.ApiResult
import com.chm.skbankdemo.api.model.Zoo
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class HomeRepository(
    private val apiService: ApiService,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.IO
) {

    suspend fun getZooInfo(): ApiResult = withContext(defaultDispatcher)  {
         apiService.getZooInfo("resourceAquire")
    }

}