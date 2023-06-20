package com.chm.skbankdemo.api

import com.chm.skbankdemo.api.model.ApiResult
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("5a0e5fbb-72f8-41c6-908e-2fb25eff9b8a")
    suspend fun getZooInfo(@Query("scope") scope: String): ApiResult
}