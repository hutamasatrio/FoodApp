package com.example.core.domain.usecase

import com.example.core.domain.model.Category
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Single
import kotlinx.coroutines.flow.Flow

interface CategoryUseCase {
    fun getCategory() : Single<List<Category>>
}