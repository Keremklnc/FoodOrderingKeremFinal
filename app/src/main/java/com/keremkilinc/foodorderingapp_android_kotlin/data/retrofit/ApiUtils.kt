package com.keremkilinc.foodorderingapp_android_kotlin.data.retrofit

import com.keremkilinc.foodorderingapp_android_kotlin.util.Constants.BASE_URL

class ApiUtils {

    companion object{
        fun getFoodService(): FoodService {
            return RetrofitClient.getClient(BASE_URL).create(FoodService::class.java)
        }
    }
}