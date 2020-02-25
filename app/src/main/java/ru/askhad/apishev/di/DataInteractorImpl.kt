package ru.askhad.apishev.di

import io.reactivex.Single
import ru.apishev.askhad.data.network.TinkoffApi
import ru.apishev.askhad.data.network.dto.Content
import ru.apishev.askhad.data.network.dto.Title

class DataInteractorImpl : DataInteractor {
    private val service = TinkoffApi.create()

    override fun getTitles(): Single<List<Title>> {
        return service.getNews()
    }

    override fun getContentById(id: String): Single<Content> {
        return service.getContentById(id)
    }
}
