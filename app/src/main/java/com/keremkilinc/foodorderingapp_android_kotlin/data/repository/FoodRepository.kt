package com.keremkilinc.foodorderingapp_android_kotlin.data.repository

import com.keremkilinc.foodorderingapp_android_kotlin.data.datasource.FoodDataSource
import com.keremkilinc.foodorderingapp_android_kotlin.data.entity.FoodEntity
import com.keremkilinc.foodorderingapp_android_kotlin.data.entity.Foods

class FoodRepository(
    private val foodDataSource: FoodDataSource
) {
    suspend fun loadFoods(): List<Foods> = foodDataSource.loadFoods()

    suspend fun addBasket(
        foodName: String,
        foodImageName: String,
        foodPrice: Int,
        foodQuantity: Int,
        userName: String
    ) =
        foodDataSource.addToBasket(foodName, foodImageName, foodPrice, foodQuantity, userName)

    suspend fun getFood(userName: String?): List<FoodEntity> = foodDataSource.loadBasket(userName)

    suspend fun deleteFood(cartFoodID: Int?, userName: String?) =
        foodDataSource.deleteFromBasket(cartFoodID, userName)

}