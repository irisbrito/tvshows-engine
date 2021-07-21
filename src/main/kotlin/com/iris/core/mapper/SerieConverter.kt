package com.iris.core.mapper

import com.iris.core.model.Serie
import com.iris.database.entity.SerieEntity
import com.iris.entrypoint.dto.SerieDto
import java.util.stream.Collectors

class SerieConverter {
    companion object {
        fun serieEntityToSerie(serieEntity: SerieEntity) =
            Serie(
                serieEntity.id,
                serieEntity.name,
                serieEntity.description,
                serieEntity.genre,
                serieEntity.whereToWatch
            )

        fun serieEntityToSerieDto(serieEntity: SerieEntity?) =
            SerieDto(
                serieEntity?.id,
                serieEntity!!.name,
                serieEntity!!.description,
                serieEntity!!.genre,
                serieEntity!!.whereToWatch
            )

        fun serieToSerieDto(serie: Serie) =
            SerieDto(
                serie.id,
                serie.name,
                serie.description,
                serie.genre,
                serie.whereToWatch
            )

        fun serieEntityListToSerieList(serieEntity: List<SerieEntity>) =
            serieEntity.stream().map { serie ->
                Serie(serie.id, serie.name,serie.description,serie.genre, serie.whereToWatch)
            }.collect(Collectors.toList())

        fun serieEntityListToSerieDtoList(serieEntity: List<SerieEntity>) =
            serieEntity.stream().map { serie ->
                SerieDto(serie.id, serie.name, serie.description, serie.genre, serie.whereToWatch)
            }.collect(Collectors.toList())

        fun serieListToSerieDtoList(serieList : List<Serie>) =
            serieList.stream().map { serie ->
                SerieDto(serie.id, serie.name, serie.description, serie.genre, serie.whereToWatch)
            }.collect(Collectors.toList())

    }
}
