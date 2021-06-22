package com.iris.repository

import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import com.iris.entity.Serie
import com.iris.exception.SerieNotFoundException
import java.util.*
import javax.inject.Singleton

@Singleton
class SerieRepoitoryImpl (private val cqlSession: CqlSession) : SerieRepository {

    override fun getAll(): List<Serie> {
        val queryResult = cqlSession.execute(
            SimpleStatement
                .newInstance(
                    "SELECT * FROM tv_shows.Series",
                )
        )
        return queryResult.map { serie ->
            Serie(
                serie.getUuid("id")!!,
                serie.getString("name")!!,
                serie.getString("description")!!,
                serie.getString("genre")!!,
                serie.getString("where_to_watch")!!
            )
        }.toList()
    }

    override fun getById(id: UUID): Serie? {
        try {
            val queryResult = cqlSession.execute(
                SimpleStatement
                    .newInstance(
                        "SELECT * FROM tv_shows.Series WHERE id= ?",
                        id
                    )
            )

            return queryResult.map { serie ->
                Serie(
                    serie.getUuid("id")!!,
                    serie.getString("name")!!,
                    serie.getString("description")!!,
                    serie.getString("genre")!!,
                    serie.getString("where_to_watch")!!
                )
            }.single()

        } catch (e: RuntimeException) {
            throw SerieNotFoundException()
        }

    }
}