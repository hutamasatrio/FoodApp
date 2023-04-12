package com.example.core.source.db.remote.response

import com.google.gson.annotations.SerializedName

data class FoodResponse(

	@field:SerializedName("meals")
	val meals: List<FoodItemResponse>
)