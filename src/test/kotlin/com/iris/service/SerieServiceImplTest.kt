package com.iris.service

import com.iris.entity.Serie
import com.iris.repository.SerieRepositoryImpl
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import java.util.*

@MicronautTest
class SerieServiceImplTest : AnnotationSpec() {

    val repository = mockk<SerieRepositoryImpl>(relaxed = true)
    val serieService = SerieServiceImpl(repository)
    lateinit var serie: Serie

    val id : UUID = UUID.fromString("3a5fd8cc-96a5-4603-8de9-3a333fa28338")

    @BeforeEach
    fun setUp(){
        serie = Serie(id, "The 100", "Série pós apocaliptica","Ficção-Cientifica", "Netflix")
    }

    @Test
    fun `should get serie by id`(){
        every {repository.getById(any())} answers {serie}
        val result = serieService.getById(id)
        result shouldBe serie
    }

    @Test
    fun `should get all series`(){
        every {repository.getAll()} answers {listOf(serie)}
        val result = serieService.getAll()
        result shouldBe listOf(serie)
    }
}