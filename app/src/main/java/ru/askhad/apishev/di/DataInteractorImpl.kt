package ru.askhad.apishev.di

import io.reactivex.Observable
import io.reactivex.Single
import ru.apishev.askhad.data.database.AppDao
import ru.apishev.askhad.data.database.AppDatabase
import ru.apishev.askhad.data.database.entity.TitleEntity
import ru.apishev.askhad.data.network.TinkoffApi
import ru.apishev.askhad.data.network.dto.ContentDto
import ru.apishev.askhad.data.network.dto.TitleDto

class DataInteractorImpl(val database: AppDatabase) : DataInteractor {
    private val service = TinkoffApi.create()
    private val dao = database.appDao()

    override fun getTitles(): Observable<List<TitleDto>> {
        return service
                .getNews()
                .doOnNext { list ->
                    list.forEach { dto ->
                        val entity = TitleEntity(
                                contentId = dto.id!!,
                                name = dto.name!!,
                                text = dto.text!!,
                                publicationDate = dto.publicationDate?.milliseconds!!,
                                bankInfoTypeId = dto.bankInfoTypeId!!
                        )
                        dao.addTitle(entity)
                    }
                }
    }

    override fun getContentById(id: String): Observable<ContentDto> {
        return service.getContentById(id)
    }
}
