package com.keremkilinc.foodorderingapp_android_kotlin.di

import com.keremkilinc.foodorderingapp_android_kotlin.data.datasource.FoodDataSource
import com.keremkilinc.foodorderingapp_android_kotlin.data.repository.FoodRepository
import com.keremkilinc.foodorderingapp_android_kotlin.data.retrofit.ApiUtils
import com.keremkilinc.foodorderingapp_android_kotlin.data.retrofit.FoodService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideFoodDataSource(foodService: FoodService) : FoodDataSource {
        return FoodDataSource(foodService)
    }

    @Provides
    @Singleton
    fun provideFoodRepository(foodDataSource: FoodDataSource) : FoodRepository {
        return FoodRepository(foodDataSource)
    }

    @Provides
    @Singleton
    fun provideFoodService() : FoodService {
        return ApiUtils.getFoodService()
    }

    /*@Provides
    @Singleton
    fun provideRetrofitInstance() : FoodDao {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(FoodDao::class.java)
    }*/
}