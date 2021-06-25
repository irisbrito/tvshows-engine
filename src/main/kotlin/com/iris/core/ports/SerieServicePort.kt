package com.iris.core.service

import com.iris.core.model.Serie
import java.util.*
import javax.inject.Singleton

@Singleton
interface SerieService {
    fun getAll(): List<Serie>
    fun getById(id: UUID): Serie?
}