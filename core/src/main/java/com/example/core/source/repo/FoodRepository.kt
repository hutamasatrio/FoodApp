package com.example.core.source.repo

import com.example.core.domain.model.Category
import com.example.core.domain.model.Food
import com.example.core.domain.model.FoodDetail
import com.example.core.domain.repository.FoodRepo
import com.example.core.source.db.remote.NetworkOnlyResources
import com.example.core.source.db.remote.RemoteDataSource
import com.example.core.source.db.remote.Resource
import com.example.core.source.db.remote.network.ApiResponse
import com.example.core.source.db.remote.network.ApiService
import com.example.core.source.db.remote.response.CategoryItemResponse
import com.example.core.source.db.remote.response.FoodDetailItemResponse
import com.example.core.source.db.remote.response.FoodItemResponse
import com.example.core.source.mapper.CategoryMapper
import com.example.core.source.mapper.FoodMapper
import kotlinx.coroutines.flow.Flow

class FoodRepository(
    private val remoteDataSource: RemoteDataSource,
    private val apiService: ApiService,
    private val foodMapper : FoodMapper
) : FoodRepo {
    override fun getFood(query : String): Flow<Resource<List<Food>>> {
        return object : NetworkOnlyResources<List<Food>, List<FoodItemResponse>>(){
            override fun loadFromNetwork(data: List<FoodItemResponse>): Flow<List<Food>> {
                return foodMapper.mapToListDomain(data)
            }

            override suspend fun createCall(): Flow<ApiResponse<List<FoodItemResponse>>> {
                return remoteDataSource.getAllFoods(query)
            }

        }.asFlow()

    }
}