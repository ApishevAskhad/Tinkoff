package ru.askhad.apishev.di

import io.reactivex.Observable
import io.reactivex.ObservableEmitter
import io.reactivex.Single
import ru.apishev.askhad.data.network.dto.ContentDto
import ru.apishev.askhad.data.network.dto.TitleDto

interface DataInteractor {
    fun getTitles(): Observable<List<TitleDto>>
    fun getContentById(id: String): Observable<ContentDto>
}
