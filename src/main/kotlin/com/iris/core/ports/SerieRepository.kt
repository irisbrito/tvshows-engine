package com.iris.core.ports

import com.iris.database.entity.SerieEntity
import java.util.*
import javax.inject.Singleton

@Singleton
interface SerieRepository {
    fun getAll(): List<SerieEntity>
    fun getById(id: UUID): SerieEntity?
}