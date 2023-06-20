package com.chm.skbankdemo.api

sealed class ApiResponse<T> {
    data class Success<T>(val data: T) : ApiResponse<T>()
    data class Fail<T>(
        val message: String? = null,
        val throwable: Throwable? = null
    ) : ApiResponse<T>()
}