package com.chm.skbankdemo.api.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Park(
    @SerializedName("e_no")
    val no: String,

    @SerializedName("e_category")
    val category: String,

    @SerializedName("e_name")
    val name: String,

    @SerializedName("e_pic_url")
    val picUrl: String,

    @SerializedName("e_info")
    val info: String,

    @SerializedName("e_memo")
    val memo: String,

    @SerializedName("e_url")
    val videoUrl: String
) : Serializable