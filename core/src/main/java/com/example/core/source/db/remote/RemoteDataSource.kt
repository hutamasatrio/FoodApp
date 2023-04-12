package com.example.core.source.db.remote

import android.util.Log
import com.example.core.source.db.remote.network.ApiResponse
import com.example.core.source.db.remote.network.ApiService
import com.example.core.source.db.remote.response.CategoryItemResponse
import com.example.core.source.db.remote.response.FoodItemResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class RemoteDataSource(private val apiService: ApiService) {


    suspend fun getAllCategories() : Flow<ApiResponse<List<CategoryItemResponse>>> =
        flow {
            try {
                val response = apiService.getCategory()
                val dataArray = response.categories
                if (dataArray.isEmpty()) {
                emit(ApiResponse.Success(response.categories))
                }
                else{
                    emit(ApiResponse.Success(dataArray))
                }
            }catch (e: Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)

    suspend fun getAllFoods(query : String) : Flow<ApiResponse<List<FoodItemResponse>>> =
        flow {
            try {
                val response = apiService.getFood(query)
                val dataArray = response.meals
                if (dataArray.isEmpty()) {
                    emit(ApiResponse.Success(response.meals))
                }
                else{
                    emit(ApiResponse.Success(dataArray))
                }
            }catch (e: Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

