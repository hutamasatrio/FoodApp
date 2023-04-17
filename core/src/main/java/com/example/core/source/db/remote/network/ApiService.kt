package com.example.core.source.db.remote.network

import com.example.core.source.db.remote.response.CategoryResponse
import com.example.core.source.db.remote.response.FoodDetailItemResponse
import com.example.core.source.db.remote.response.FoodDetailResponse
import com.example.core.source.db.remote.response.FoodResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("categories.php")
    suspend fun getCategory(): CategoryResponse

    @GET("filter.php")
    suspend fun getFood(
        @Query("c") query: String
    ): FoodResponse

    @GET("lookup.php")
    suspend fun getDetail(
        @Query("i") query: String
    ): FoodDetailResponse
}