package com.iris.repository

import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import com.iris.entity.Serie
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.sequences.singleElement
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import java.util.*

@MicronautTest
class SerieRepositoryImplTest : AnnotationSpec() {

    val cqlSession = mockk<CqlSession>(relaxed = true)
    val serieRepositoryImpl = SerieRepositoryImpl(cqlSession)
    lateinit var serie: Serie
    val id : UUID = UUID.fromString("3a5fd8cc-96a5-4603-8de9-3a333fa28338")

    @BeforeEach
    fun setUp() {
        serie = Serie(id, "The 100", "Série pós apocaliptica","Ficção-Cientifica", "Netflix")
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
            Serie(
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

  /*  @Test
    fun `should return serie by id`(){
        val queryResult = cqlSession.execute(
            SimpleStatement
                .newInstance(
                    "SELECT * FROM tv_shows.Series WHERE id= ?",
                    id
                )
        )
    queryResult.map { serie ->
            Serie(
                serie.getUuid("3a5fd8cc-96a5-4603-8de9-3a333fa28338")!!,
                serie.getString("The 100")!!,
                serie.getString("Série pós apocaliptica")!!,
                serie.getString("Ficção-Cientifica")!!,
                serie.getString("Netflix")!!
            )
        }.single()

        val result = serieRepositoryImpl.getById(id)

        result shouldBe queryResult
    }*/
}