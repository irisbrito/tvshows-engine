package com.iris.database.repository

import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import com.iris.core.ports.SerieRepository
import com.iris.database.entity.SerieEntity
import com.iris.database.exception.SerieNotFoundException
import java.util.*
import javax.inject.Singleton

@Singleton
class SerieRepositoryImpl (private val cqlSession: CqlSession) : SerieRepository {

    override fun getAll(): List<SerieEntity> {
        val queryResult = cqlSession.execute(
            SimpleStatement
                .newInstance(
                    "SELECT * FROM tv_shows.Series",
                )
        )
        return queryResult.map { serie ->
            SerieEntity(
                serie.getUuid("id")!!,
                serie.getString("name")!!,
                serie.getString("description")!!,
                serie.getString("genre")!!,
                serie.getString("where_to_watch")!!
            )
        }.toList()
    }

    override fun getById(id: UUID): SerieEntity? {
        try {
            val queryResult = cqlSession.execute(
                SimpleStatement
                    .newInstance(
                        "SELECT * FROM tv_shows.Series WHERE id= ?",
                        id
                    )
            )

            return queryResult.map { serie ->
                SerieEntity(
                    serie.getUuid("id")!!,
                    serie.getString("name")!!,
                    serie.getString("description")!!,
                    serie.getString("genre")!!,
                    serie.getString("where_to_watch")!!
                )
            }.firstOrNull()

        } catch (e: RuntimeException) {
            throw RuntimeException()
        }

    }
}