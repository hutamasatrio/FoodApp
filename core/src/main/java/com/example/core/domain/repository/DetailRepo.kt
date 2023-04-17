package com.example.core.domain.repository

import com.example.core.domain.model.Category
import com.example.core.domain.model.FoodDetail
import com.example.core.source.db.remote.Resource
import kotlinx.coroutines.flow.Flow

interface DetailRepo {
    fun getDetail(query: String): Flow<Resource<List<FoodDetail>>>

}