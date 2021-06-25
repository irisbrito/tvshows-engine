package com.iris.core.service

import com.iris.core.model.Serie
import com.iris.database.repository.SerieRepository
import java.util.*
import javax.inject.Singleton

@Singleton
class SerieServiceImpl(private val serieRepository: SerieRepository) : SerieService {

    override fun getAll(): List<Serie> {
        return serieRepository.getAll()
    }

    override fun getById(id: UUID): Serie? {
        return serieRepository.getById(id)
    }
}