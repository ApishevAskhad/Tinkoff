package ru.askhad.apishev.di

import io.reactivex.Single
import ru.apishev.askhad.data.network.dto.Content
import ru.apishev.askhad.data.network.dto.Title

interface DataInteractor {
    fun getTitles(): Single<List<Title>>
    fun getContentById(id: String): Single<Content>
}
