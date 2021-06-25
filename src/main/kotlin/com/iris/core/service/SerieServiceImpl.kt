package com.iris.core.service

import com.iris.core.mapper.SerieConverter
import com.iris.core.model.Serie
import com.iris.core.ports.SerieServicePort
import com.iris.core.ports.SerieRepository
import java.util.*
import javax.inject.Singleton

@Singleton
class SerieServiceImpl(private val serieRepository: SerieRepository) : SerieServicePort {

    override fun getAll(): List<Serie> =
        SerieConverter.serieEntityListToSerieList(serieRepository.getAll())

    override fun getById(id: UUID): Serie? =
        SerieConverter.serieEntityToSerie(serieRepository.getById(id)!!)

}