package com.example.core.source.repo

import androidx.lifecycle.asFlow
import com.example.core.domain.model.FoodDetail
import com.example.core.domain.repository.DetailRepo
import com.example.core.source.db.lokal.entity.DetailFoodEntity
import com.example.core.source.db.lokal.room.FavoriteDao
import com.example.core.source.db.remote.NetworkOnlyResources
import com.example.core.source.db.remote.RemoteDataSource
import com.example.core.source.db.remote.Resource
import com.example.core.source.db.remote.network.ApiResponse
import com.example.core.source.db.remote.response.FoodDetailItemResponse
import com.example.core.source.mapper.DetailEntityMapper
import com.example.core.source.mapper.DetailMapper
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import java.util.concurrent.Executor

class DetailRepository (
    private val remoteDataSource: RemoteDataSource,
    private val detailMapper : DetailMapper,
    private val detailEntityMapper: DetailEntityMapper,
    private val executor: Executor,
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

        runBlocking {
            val toModel = detailEntityMapper.mapToModel(food)
            val job = GlobalScope.launch {
                executor.execute { dao.insertFood(toModel) }
            }
            job.join()
        }

//        Thread{
//            val toModel = detailEntityMapper.mapToModel(food)
//            dao.insertFood(toModel)
//        }

    }

    override fun deleteFood(id: String) {
        executor.execute{dao.deleteFood(id)}
    }

    override fun cekFav(id: String): Flow<List<DetailFoodEntity>> {
        return dao.cekFavorite(id).asFlow()

    }

    override fun mapper(food: List<DetailFoodEntity>): List<FoodDetail> {
        return  detailEntityMapper.mapToListDomain(food)
    }
}