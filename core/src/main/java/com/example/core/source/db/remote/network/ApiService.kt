package com.example.core.source.db.remote.network

import com.example.core.source.db.remote.response.CategoryResponse
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface ApiService {
    @GET("categories.php")
    fun getCategory(): Single<CategoryResponse>
}