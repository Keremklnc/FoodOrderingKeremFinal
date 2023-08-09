package com.keremkilinc.foodorderingapp_android_kotlin.data.entity

import com.google.gson.annotations.SerializedName

data class FoodsItem(
    @SerializedName("yemekler")
    val foods: List<Foods>,
    val success: Int
)