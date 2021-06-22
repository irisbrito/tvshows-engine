package com.iris.service

import com.iris.entity.Serie
import java.util.*
import javax.inject.Singleton

@Singleton
interface SerieService {
    fun getAll(): List<Serie>
    fun getById(id: UUID): Serie?
}