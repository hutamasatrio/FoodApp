package com.example.core.domain.usecase.detail

import com.example.core.domain.model.FoodDetail
import com.example.core.domain.repository.DetailRepo
import com.example.core.domain.repository.FoodRepo
import com.example.core.domain.usecase.food.FoodUseCase
import com.example.core.source.db.remote.Resource
import kotlinx.coroutines.flow.Flow

class DetailInteractor (private val detailRepo: DetailRepo) : DetailUseCase {
    override fun getDetail(query: String) = detailRepo.getDetail(query)
    override fun favFood(food: FoodDetail) = detailRepo.saveFood(food)

}


