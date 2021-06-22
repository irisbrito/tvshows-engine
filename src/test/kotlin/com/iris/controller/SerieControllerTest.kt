package com.iris.controller

import com.iris.entity.Serie
import com.iris.service.SerieServiceImpl
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import java.util.*

@MicronautTest
class SerieControllerTest : AnnotationSpec() {

    val service = mockk<SerieServiceImpl>(relaxed = true)
    val serieController = SerieController(service)
    lateinit var serie: Serie
    val id : UUID = UUID.fromString("3a5fd8cc-96a5-4603-8de9-3a333fa28338")

    @BeforeEach
    fun setUp(){
        serie = Serie(id, "The 100", "Série pós apocaliptica","Ficção-Cientifica", "Netflix")
    }

    @Test
    fun `should get all series`(){
        every {service.getAll()} answers {listOf(serie)}
        val result = serieController.getSeries().body()
        result shouldBe listOf(serie)
    }

    @Test
    fun `should get serie by id`(){
        every {service.getById(any())} answers {serie}
        val result = serieController.getSerieById(id).body()
        result shouldBe serie
    }
}