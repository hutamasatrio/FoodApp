package com.example.foodappdagger.core.data.mapper

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

interface BaseMapper1<Model, Domain> {
    fun mapToDomain(model: Model): Domain
    fun mapToModel(domain: Domain): Model

    fun mapToListDomain(models: List<Model>): List<Domain> {
        val listDomain = ArrayList<Domain>()
        models.map { listDomain.add(mapToDomain(it)) }
        return listDomain
    }


}