package com.example.core.source.db.remote

import com.example.core.source.db.remote.network.ApiResponse
import kotlinx.coroutines.flow.*

abstract class NetworkOnlyResources <ResultType, RequestType > {
    private val result : Flow<Resource<ResultType>> = flow {
        emit(Resource.Loading())
        when (val apiResponse = createCall().first()){
            is ApiResponse.Success -> {
                emitAll(loadFromNetwork(apiResponse.data).map{
                    Resource.Success(it)
                })
            }
            is ApiResponse.Error ->{
                emit(Resource.Error<ResultType>(apiResponse.errorMessage))
            }
            else -> {}
        }
    }

    protected abstract fun loadFromNetwork(data: RequestType): Flow<ResultType>

    protected abstract suspend fun createCall(): Flow<ApiResponse<RequestType>>
    
    fun asFlow(): Flow<Resource<ResultType>> = result
}