package com.example.core.source.mapper

interface BaseMapperEntity<Model, Domain> {
    fun mapToDomain(model: Model): Domain
    fun mapToModel(domain: Domain): Model

    fun mapToListDomain(models: List<Model>): List<Domain> {
        val listDomain = ArrayList<Domain>()
        models.map { listDomain.add(mapToDomain(it)) }
        return listDomain
    }


}