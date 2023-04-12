package com.example.core.domain.usecase.category

import com.example.core.domain.repository.CategoryRepo

class CategoryInteractor (private val categoryRepo : CategoryRepo) : CategoryUseCase {
    override fun getCategory() = categoryRepo.getCategory()
}