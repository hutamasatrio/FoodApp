package com.example.core.domain.repository

import com.example.core.domain.model.Food
import com.example.core.domain.model.FoodDetail
import com.example.core.source.db.remote.Resource
import kotlinx.coroutines.flow.Flow

interface FoodRepo {
    fun getFood(query: String): Flow<Resource<List<Food>>>

}