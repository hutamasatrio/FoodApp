package com.example.core.domain.usecase.detail

import com.example.core.domain.model.Food
import com.example.core.domain.model.FoodDetail
import com.example.core.source.db.remote.Resource
import kotlinx.coroutines.flow.Flow

interface DetailUseCase {
    fun getDetail(query: String) : Flow<Resource<List<FoodDetail>>>
    fun favFood(food : FoodDetail)
}

