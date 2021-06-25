package com.iris.repository

import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import com.iris.database.repository.SerieRepositoryImpl
import com.iris.core.model.Serie
import com.iris.database.entity.SerieEntity
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.mockk
import java.util.*

@MicronautTest
class SerieRepositoryImplTest : AnnotationSpec() {

    val cqlSession = mockk<CqlSession>(relaxed = true)
    val serieRepositoryImpl = SerieRepositoryImpl(cqlSession)
    lateinit var serie: SerieEntity
    val id : UUID = UUID.fromString("0e337aaf-2458-4ff8-9116-84492b8d29b1")

    @BeforeEach
    fun setUp() {
        serie = SerieEntity(id, "The 100", "Série pós apocaliptica","Ficção-Cientifica", "Netflix")
    }

    @Test
    fun `should return all series`(){
        val queryResult = cqlSession.execute(
            SimpleStatement
                .newInstance(
                    "SELECT * FROM tv_shows.Series",
                )
        )
        val listOfSeries = queryResult.map { serie ->
            SerieEntity(
                serie.getUuid("id")!!,
                serie.getString("name")!!,
                serie.getString("description")!!,
                serie.getString("genre")!!,
                serie.getString("where_to_watch")!!
            )
        }.toList()

        val result = serieRepositoryImpl.getAll()

        result shouldBe listOfSeries
    }

  /*@Test
    fun `should return serie by id`(){
        val queryResult = cqlSession.execute(
            SimpleStatement
                .newInstance(
                    "SELECT * FROM tv_shows.Series WHERE id= ?",
                    serie.id
                )
        ).map { serie ->
            Serie(
                serie.getUuid("0e337aaf-2458-4ff8-9116-84492b8d29b1")!!,
                serie.getString("name")!!,
                serie.getString("description")!!,
                serie.getString("genre")!!,
                serie.getString("where_to_watch")!!
            )
        }.firstOrNull()

        val result = serieRepositoryImpl.getById(serie.id!!)

        result shouldBe queryResult
    }*/
}