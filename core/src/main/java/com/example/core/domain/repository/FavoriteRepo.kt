package com.example.core.domain.repository

import androidx.lifecycle.LiveData
import com.example.core.domain.model.Food
import com.example.core.domain.model.FoodDetail
import com.example.core.source.db.lokal.entity.DetailFoodEntity
import com.example.core.source.db.remote.Resource
import kotlinx.coroutines.flow.Flow


interface FavoriteRepo {
    fun getFavorite() : Flow<List<FoodDetail>>
//    fun setFavoriteTourism(food: FoodDetail, state: Boolean)



}