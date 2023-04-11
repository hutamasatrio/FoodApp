package com.example.foodappdagger.core.data.mapper

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

interface BaseMapper<Model, Domain> {
    fun mapToDomain(model: Model): Domain
    fun mapToModel(domain: Domain): Model

    fun mapToListDomain(models: List<Model>): Flow<List<Domain>> {
        val listDomain = ArrayList<Domain>()
        models.map { listDomain.add(mapToDomain(it)) }
        return flowOf(listDomain)
    }

    fun mapToListModel(domains: List<Domain>): List<Model> {
        val listModels = mutableListOf<Model>()
        domains.map { listModels.add(mapToModel(it)) }
        return listModels
    }
}