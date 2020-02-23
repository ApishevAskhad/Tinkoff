package ru.askhad.apishev.network

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query
import ru.askhad.apishev.model.Content
import ru.askhad.apishev.model.Titles

interface TinkoffApi {
    @GET("news")
    fun getNews(): Single<Titles>

    @GET("news_content")
    fun getContent(@Query(value = "id", encoded = true) id: String): Single<Content>
}