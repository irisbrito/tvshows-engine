package com.iris.core.ports

import com.iris.core.model.Serie
import java.util.*
import javax.inject.Singleton

@Singleton
interface SerieServicePort {
    fun getAll(): List<Serie>
    fun getById(id: UUID): Serie?
}