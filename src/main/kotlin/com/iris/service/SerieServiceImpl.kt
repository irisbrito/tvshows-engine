package com.iris.service

import com.iris.entity.Serie
import com.iris.repository.SerieRepository
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