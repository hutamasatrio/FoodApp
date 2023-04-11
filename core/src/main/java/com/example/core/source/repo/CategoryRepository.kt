package com.example.core.source.repo

import com.example.core.domain.model.Category
import com.example.core.domain.repository.CategoryRepo
import com.example.core.source.db.remote.NetworkOnlyResources
import com.example.core.source.db.remote.RemoteDataSource
import com.example.core.source.db.remote.Resource
import com.example.core.source.db.remote.network.ApiResponse
import com.example.core.source.db.remote.network.ApiService
import com.example.core.source.db.remote.response.CategoryItemResponse
import com.example.core.source.mapper.CategoryMapper
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.flow.*

class CategoryRepository(
    private val remoteDataSource: RemoteDataSource,
    private val apiService: ApiService,
    private val categoryMapper : CategoryMapper
) : CategoryRepo {
    //    override fun getCategory() = apiService.getCategory()
//            .map {
//                categoryMapper.mapToListDomain(it.categories)
//             }
//        .subscribeOn(Schedulers.io())
//        .observeOn(AndroidSchedulers.mainThread())
    override fun getCategory(): Flow<Resource<List<Category>>> {
        return object : NetworkOnlyResources<List<Category>, List<CategoryItemResponse>>() {
            override fun loadFromNetwork(data: List<CategoryItemResponse>): Flow<List<Category>> {
                return categoryMapper.mapToListDomain(data)
            }

            override suspend fun createCall(): Flow<ApiResponse<List<CategoryItemResponse>>> {
                return remoteDataSource.getAllCategories()
            }


        }.asFlow()
    }


}