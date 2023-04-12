package com.example.core.source.db.remote.response

import com.google.gson.annotations.SerializedName

data class FoodDetailResponse(

	@field:SerializedName("meals")
	val meals: List<FoodDetailItemResponse?>? = null
)