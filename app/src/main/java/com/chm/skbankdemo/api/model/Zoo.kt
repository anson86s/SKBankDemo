package com.chm.skbankdemo.api.model

import com.google.gson.annotations.SerializedName

data class Zoo(
    @SerializedName("limit")
    val limit: Int,

    @SerializedName("offset")
    val offset: Int,

    @SerializedName("count")
    val count: Int,

    @SerializedName("sort")
    val sort: String,

    @SerializedName("results")
    val results: List<Park>
)