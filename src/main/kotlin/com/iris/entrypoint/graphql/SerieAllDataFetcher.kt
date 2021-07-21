package com.iris.entrypoint.graphql

import com.iris.core.mapper.SerieConverter
import com.iris.core.ports.SerieRepository
import com.iris.entrypoint.dto.SerieDto
import graphql.schema.DataFetcher
import graphql.schema.DataFetchingEnvironment
import javax.inject.Singleton

@Singleton
class SerieAllDataFetcher(private val serieRepository: SerieRepository) : DataFetcher<List<SerieDto>>{
    override fun get(environment: DataFetchingEnvironment?): List<SerieDto> {
        return SerieConverter.serieEntityListToSerieDtoList(serieRepository.getAll())
    }

}