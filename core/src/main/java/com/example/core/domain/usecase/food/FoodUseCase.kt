package com.example.core.domain.usecase.food

import com.example.core.domain.model.Food
import com.example.core.source.db.remote.Resource
import kotlinx.coroutines.flow.Flow

interface FoodUseCase {
    fun getAllFood(query: String) : Flow<Resource<List<Food>>>
}