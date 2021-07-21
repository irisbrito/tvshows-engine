package com.iris.entrypoint.graphql

import com.iris.core.mapper.SerieConverter
import com.iris.core.ports.SerieRepository
import com.iris.entrypoint.dto.SerieDto
import graphql.schema.DataFetcher
import graphql.schema.DataFetchingEnvironment
import java.util.UUID
import javax.inject.Singleton

@Singleton
class SerieByIdDataFetcher(private val serieRepository: SerieRepository) : DataFetcher<SerieDto> {
    override fun get(environment: DataFetchingEnvironment?): SerieDto {
        val env = environment!!.getArgument<UUID>("id")
        return SerieConverter.serieEntityToSerieDto(serieRepository.getById(env!!))

    }
}