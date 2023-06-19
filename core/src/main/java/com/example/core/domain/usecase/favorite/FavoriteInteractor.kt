package com.example.core.domain.usecase.favorite

import com.example.core.domain.model.FoodDetail
import com.example.core.domain.repository.DetailRepo
import com.example.core.domain.repository.FavoriteRepo
import com.example.core.domain.usecase.detail.DetailUseCase
import com.example.core.source.db.lokal.entity.DetailFoodEntity
import com.example.core.source.db.remote.Resource
import kotlinx.coroutines.flow.Flow

class FavoriteInteractor (private val favoriteRepo: FavoriteRepo) : FavoriteUseCase {
    override fun getFavorite() = favoriteRepo.getFavorite()
//    override fun mappingToObject(result: List<DetailFoodEntity>): List<FoodDetail> =
//        favoriteRepo.mappingToObject(result)
}