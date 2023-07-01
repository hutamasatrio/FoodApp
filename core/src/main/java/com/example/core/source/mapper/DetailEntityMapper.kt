package com.example.core.source.mapper

import com.example.core.domain.model.FoodDetail
import com.example.core.source.db.lokal.entity.DetailFoodEntity
import com.example.foodappdagger.core.data.mapper.BaseMapperEntity

class DetailEntityMapper : BaseMapperEntity<DetailFoodEntity, FoodDetail> {
    override fun mapToDomain(model: DetailFoodEntity): FoodDetail {
        return FoodDetail(
            model.strIngredient10,
            model.strIngredient12,
            model.strIngredient11,
            model.strIngredient14,
            model.strCategory,
            model.strIngredient13,
            model.strIngredient16,
            model.strIngredient15,
            model.strIngredient18,
            model.strIngredient17,
            model.strArea,
            model.strIngredient19,
            model.strTags,
            model.idMeal,
            model.strInstructions,
            model.strIngredient1,
            model.strIngredient3,
            model.strIngredient2,
            model.strIngredient20,
            model.strIngredient5,
            model.strIngredient4,
            model.strIngredient7,
            model.strIngredient6,
            model.strIngredient9,
            model.strIngredient8,
            model.strMealThumb,
            model.strMeasure20,
            model.strYoutube,
            model.strMeal,
            model.strMeasure12,
            model.strMeasure13,
            model.strMeasure10,
            model.strMeasure11,
            model.strSource,
            model.strMeasure9,
            model.strMeasure7,
            model.strMeasure8,
            model.strMeasure5,
            model.strMeasure6,
            model.strMeasure3,
            model.strMeasure4,
            model.strMeasure1,
            model.strMeasure18,
            model.strMeasure2,
            model.strMeasure19,
            model.strMeasure16,
            model.strMeasure17,
            model.strMeasure14,
            model.strMeasure15
            )
    }

    override fun mapToModel(domain: FoodDetail): DetailFoodEntity {
        return DetailFoodEntity(
            domain.strIngredient10.toString(),
            domain.strIngredient12.toString(),
            domain.strIngredient11.toString(),
            domain.strIngredient14.toString(),
            domain.strCategory.toString(),
            domain.strIngredient13.toString(),
            domain.strIngredient16.toString(),
            domain.strIngredient15.toString(),
            domain.strIngredient18.toString(),
            domain.strIngredient17.toString(),
            domain.strArea.toString(),
            domain.strIngredient19.toString(),
            domain.strTags.toString(),
            domain.idMeal.toString(),
            domain.strInstructions.toString(),
            domain.strIngredient1.toString(),
            domain.strIngredient3.toString(),
            domain.strIngredient2.toString(),
            domain.strIngredient20.toString(),
            domain.strIngredient5.toString(),
            domain.strIngredient4.toString(),
            domain.strIngredient7.toString(),
            domain.strIngredient6.toString(),
            domain.strIngredient9.toString(),
            domain.strIngredient8.toString(),
            domain.strMealThumb.toString(),
            domain.strMeasure20.toString(),
            domain.strYoutube.toString(),
            domain.strMeal.toString(),
            domain.strMeasure12.toString(),
            domain.strMeasure13.toString(),
            domain.strMeasure10.toString(),
            domain.strMeasure11.toString(),
            domain.strSource.toString(),
            domain.strMeasure9.toString(),
            domain.strMeasure7.toString(),
            domain.strMeasure8.toString(),
            domain.strMeasure5.toString(),
            domain.strMeasure6.toString(),
            domain.strMeasure3.toString(),
            domain.strMeasure4.toString(),
            domain.strMeasure1.toString(),
            domain.strMeasure18.toString(),
            domain.strMeasure2.toString(),
            domain.strMeasure19.toString(),
            domain.strMeasure16.toString(),
            domain.strMeasure17.toString(),
            domain.strMeasure14.toString(),
            domain.strMeasure15.toString()
        )
    }
}