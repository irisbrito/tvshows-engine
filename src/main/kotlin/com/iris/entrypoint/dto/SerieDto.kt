package com.iris.entrypoint.dto

import java.util.*

data class SerieDto(
    val id: UUID? = null,
    var name: String = "",
    var description: String = "",
    var genre: String = "",
    var whereToWatch: String = "",
)
