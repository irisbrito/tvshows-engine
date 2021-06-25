package com.iris.entrypoint.controller

import com.iris.core.model.Serie
import com.iris.core.service.SerieServiceImpl
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import java.util.*

@Controller("/series")
class SerieController(private val serieService: SerieServiceImpl) {

    @Get
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun getSeries(): HttpResponse<List<Serie?>> =
        HttpResponse.ok(HttpStatus.OK).body(this.serieService.getAll())

    @Get("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun getSerieById(@PathVariable id: UUID): HttpResponse<Serie> =
        HttpResponse.ok(HttpStatus.OK).body(this.serieService.getById(id))

}