package com.example.core.source.repo

import android.app.DownloadManager
import com.example.core.domain.model.FoodDetail
import com.example.core.domain.repository.DetailRepo
import com.example.core.source.db.lokal.room.FavoriteDao
import com.example.core.source.db.remote.NetworkOnlyResources
import com.example.core.source.db.remote.RemoteDataSource
import com.example.core.source.db.remote.Resource
import com.example.core.source.db.remote.network.ApiResponse
import com.example.core.source.db.remote.network.ApiService
import com.example.core.source.db.remote.response.FoodDetailItemResponse
import com.example.core.source.db.remote.response.FoodDetailResponse
import com.example.core.source.mapper.CategoryMapper
import com.example.core.source.mapper.DetailEntityMapper
import com.example.core.source.mapper.DetailMapper
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.security.PrivateKey

class DetailRepository (
    private val remoteDataSource: RemoteDataSource,
    private val apiService: ApiService,
    private val detailMapper : DetailMapper,
    private val detailEntityMapper: DetailEntityMapper,
    private val dao : FavoriteDao
        ): DetailRepo {
    override fun getDetail(query: String): Flow<Resource<List<FoodDetail>>> {
        return object : NetworkOnlyResources<List<FoodDetail>, List<FoodDetailItemResponse>>(){
            override fun loadFromNetwork(data: List<FoodDetailItemResponse>): Flow<List<FoodDetail>> {
                return detailMapper.mapToListDomain(data)
            }

            override suspend fun createCall(): Flow<ApiResponse<List<FoodDetailItemResponse>>> {
                return remoteDataSource.getDetail(query)
            }

        }.asFlow()
    }

    override fun saveFood(food: FoodDetail) {
        val toModel = detailEntityMapper.mapToModel(food)
        dao.insertFood(toModel)
    }
}