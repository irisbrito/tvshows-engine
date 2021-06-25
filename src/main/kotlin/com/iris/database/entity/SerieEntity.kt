package com.iris.database.entity

import java.util.*

data class SerieEntity(
    val id: UUID? = null,
    var name: String = "",
    var description: String = "",
    var genre: String = "",
    var whereToWatch: String = "",
)
