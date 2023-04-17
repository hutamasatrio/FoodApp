package com.example.core.source.db.remote

import android.util.Log
import com.example.core.source.db.remote.network.ApiResponse
import com.example.core.source.db.remote.network.ApiService
import com.example.core.source.db.remote.response.CategoryItemResponse
import com.example.core.source.db.remote.response.FoodDetailItemResponse
import com.example.core.source.db.remote.response.FoodItemResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val apiService: ApiService) {


    suspend fun getAllCategories(): Flow<ApiResponse<List<CategoryItemResponse>>> =
        flow {
            try {
                val response = apiService.getCategory()
                val dataArray = response.categories
                if (dataArray.isEmpty()) {
                    emit(ApiResponse.Success(dataArray))
                } else {
                    emit(ApiResponse.Success(dataArray))
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)

    suspend fun getAllFoods(query: String): Flow<ApiResponse<List<FoodItemResponse>>> =
        flow {
            try {
                val response = apiService.getFood(query)
                val dataArray = response.meals
                if (dataArray.isEmpty()) {
                    emit(ApiResponse.Success(dataArray))
                } else {
                    emit(ApiResponse.Success(dataArray))
                }
            } catch (e: Exception) {
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)

    suspend fun getDetail(query: String): Flow<ApiResponse<List<FoodDetailItemResponse>>> =
        flow {
            try{
                val response = apiService.getDetail(query)
                val dataArray = response.meals
                if (dataArray?.isEmpty() == true) {
                    emit(ApiResponse.Success(dataArray))
                } else{
                    emit(ApiResponse.Success(dataArray))
                }
            } catch (e : Exception){
                emit(ApiResponse.Error(e.toString()))
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO) as Flow<ApiResponse<List<FoodDetailItemResponse>>>
}




