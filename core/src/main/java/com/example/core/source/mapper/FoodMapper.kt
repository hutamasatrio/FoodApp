package com.example.core.source.mapper

import com.example.core.domain.model.Food
import com.example.core.source.db.remote.response.FoodItemResponse
import com.example.foodappdagger.core.data.mapper.BaseMapper

class FoodMapper : BaseMapper<FoodItemResponse, Food> {
    override fun mapToDomain(model: FoodItemResponse): Food {
        return Food(
            model.idMeal,
            model.strMeal,
            model.strMealThumb
        )
    }


    override fun mapToModel(domain: Food): FoodItemResponse {
        return FoodItemResponse(
            domain.strMeal,
            domain.idMeal,
            domain.strMealThumb
        )
    }
}


