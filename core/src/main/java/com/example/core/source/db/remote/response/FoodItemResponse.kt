package com.example.core.source.db.remote.response

import com.google.gson.annotations.SerializedName

data class FoodItemResponse(

    @field:SerializedName("strMealThumb")
    val strMealThumb: String,

    @field:SerializedName("idMeal")
    val idMeal: String?,

    @field:SerializedName("strMeal")
    val strMeal: String
)