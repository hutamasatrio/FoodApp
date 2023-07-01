package com.example.core.source.mapper

import com.example.core.domain.model.Category
import com.example.core.source.db.remote.response.CategoryItemResponse
import com.example.foodappdagger.core.data.mapper.BaseMapper

class CategoryMapper : BaseMapper<CategoryItemResponse,Category> {
    override fun mapToDomain(model: CategoryItemResponse): Category {
        return Category(
            model.strCategory,
            model.strCategoryDescription,
            model.idCategory,
            model.strCategoryThumb
        )
    }

    override fun mapToModel(domain: Category): CategoryItemResponse {
        return CategoryItemResponse(
            domain.strCategory,
            domain.strCategoryDescription,
            domain.idCategory,
            domain.strCategoryThumb
        )
    }
}

//interface CategoryMapper : BaseMapper<CategoryItemResponse,Category>