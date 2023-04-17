package com.example.core.source.repo

import android.app.DownloadManager
import com.example.core.domain.model.FoodDetail
import com.example.core.domain.repository.DetailRepo
import com.example.core.source.db.remote.NetworkOnlyResources
import com.example.core.source.db.remote.RemoteDataSource
import com.example.core.source.db.remote.Resource
import com.example.core.source.db.remote.network.ApiResponse
import com.example.core.source.db.remote.network.ApiService
import com.example.core.source.db.remote.response.FoodDetailItemResponse
import com.example.core.source.db.remote.response.FoodDetailResponse
import com.example.core.source.mapper.CategoryMapper
import com.example.core.source.mapper.DetailMapper
import kotlinx.coroutines.flow.Flow

class DetailRepository (
    private val remoteDataSource: RemoteDataSource,
    private val apiService: ApiService,
    private val detailMapper : DetailMapper
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
}