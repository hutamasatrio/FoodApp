package com.example.core.domain.usecase.category

import com.example.core.domain.model.Category
import com.example.core.source.db.remote.Resource
import kotlinx.coroutines.flow.Flow

interface CategoryUseCase {
    fun getCategory() : Flow<Resource<List<Category>>>
}