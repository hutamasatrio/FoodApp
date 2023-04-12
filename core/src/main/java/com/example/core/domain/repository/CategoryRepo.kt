package com.example.core.domain.repository

import com.example.core.domain.model.Category
import com.example.core.source.db.remote.Resource
import kotlinx.coroutines.flow.Flow

interface CategoryRepo {
    fun getCategory(): Flow<Resource<List<Category>>>
}