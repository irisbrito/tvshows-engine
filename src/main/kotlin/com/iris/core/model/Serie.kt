package com.iris.core.entity

import java.util.*

data class Serie(
    val id: UUID? = null,
    var name: String = "",
    var description: String = "",
    var genre: String = "",
    var whereToWatch: String = "",
)
