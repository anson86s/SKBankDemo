package com.chm.skbankdemo.api.model

import com.google.gson.annotations.SerializedName

data class ApiResult(
    @SerializedName("result")
    val data: Zoo
)