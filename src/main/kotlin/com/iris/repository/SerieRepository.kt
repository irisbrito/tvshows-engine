package com.iris.repository

import com.iris.entity.Serie
import java.util.*
import javax.inject.Singleton

@Singleton
interface SerieRepository {
    fun getAll(): List<Serie>
    fun getById(id: UUID): Serie?
}