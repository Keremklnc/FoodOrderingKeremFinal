package com.keremkilinc.foodorderingapp_android_kotlin.data.entity

import com.google.gson.annotations.SerializedName

data class FoodEntityItem(
    @SerializedName("sepet_yemekler")
    val foodEntities: List<FoodEntity>,
    val success: Int
)