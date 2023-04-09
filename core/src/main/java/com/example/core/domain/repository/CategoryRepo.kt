package com.example.core.domain.repository

import com.example.core.domain.model.Category
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import kotlinx.coroutines.flow.Flow

interface CategoryRepo {
    fun getCategory(): Single<List<Category>>
}