package com.example.core.source.repo

import com.example.core.domain.model.Category
import com.example.core.domain.repository.CategoryRepo
import com.example.core.source.db.remote.network.ApiService
import com.example.core.source.mapper.CategoryMapper
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.observeOn
import kotlinx.coroutines.flow.subscribeOn

class CategoryRepository(
    private val apiService: ApiService,
    private val categoryMapper : CategoryMapper
) : CategoryRepo {
    override fun getCategory() = apiService.getCategory()
            .map {
                categoryMapper.mapToListDomain(it.categories)
             }
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())



}