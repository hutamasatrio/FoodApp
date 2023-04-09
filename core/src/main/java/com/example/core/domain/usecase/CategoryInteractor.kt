package com.example.core.domain.usecase

import com.example.core.domain.model.Category
import com.example.core.domain.repository.CategoryRepo
import io.reactivex.Single

class CategoryInteractor (private val categoryRepository : CategoryRepo) : CategoryUseCase{
    override fun getCategory() = categoryRepository.getCategory()
}