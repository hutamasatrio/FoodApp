package com.example.core.domain.usecase

import com.example.core.domain.model.Category
import com.example.core.source.db.remote.Resource
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import kotlinx.coroutines.flow.Flow

interface CategoryUseCase {
    fun getCategory() : Flow<Resource<List<Category>>>
}