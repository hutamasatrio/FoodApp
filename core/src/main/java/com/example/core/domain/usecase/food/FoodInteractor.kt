package com.example.core.domain.usecase.food

import com.example.core.domain.repository.FoodRepo
import com.example.core.source.repo.FoodRepository

class FoodInteractor (private val foodRepo: FoodRepo): FoodUseCase {
    override fun getAllFood(query: String) = foodRepo.getFood(query)
    }

