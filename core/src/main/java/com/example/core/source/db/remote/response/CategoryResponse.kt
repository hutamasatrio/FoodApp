package com.example.core.source.db.remote.response

import com.google.gson.annotations.SerializedName

data class CategoryResponse (
    @field:SerializedName("categories")
    val categories: List<CategoryItemResponse>

)