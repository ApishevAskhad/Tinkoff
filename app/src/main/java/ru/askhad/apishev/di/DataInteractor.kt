package ru.askhad.apishev.di

import io.reactivex.Single
import ru.apishev.askhad.data.network.dto.Title

interface DataInteractor {
    fun getTitles(): Single<List<Title>>
}