package com.chm.skbankdemo.api

import retrofit2.HttpException
import java.io.IOException

suspend fun <T> safeApiCall(
    apiCall: suspend () -> T
): ApiResponse<T> {
    return try {
        ApiResponse.Success(apiCall.invoke())
    } catch (throwable: Throwable) {
        when (throwable) {
            is IOException -> ApiResponse.Fail(
                "${throwable.message} IOException : Network error !!",
                throwable
            )
            is HttpException -> {
                ApiResponse.Fail(throwable.message ?: "", throwable)
            }
            else -> {
                ApiResponse.Fail(throwable.message, throwable)
            }
        }
    }
}