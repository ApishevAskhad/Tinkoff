package ru.askhad.apishev.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.apishev.askhad.data.network.dto.ContentDto
import ru.askhad.apishev.di.DataInteractor
import ru.askhad.apishev.view_model.support.RxViewModel

class ContentViewModel(
        private val dataInteractor: DataInteractor
) : RxViewModel() {
    private val _result = MutableLiveData<ContentDto>()
    val result: LiveData<ContentDto> = _result

    fun onContentLoad(id: String) {
        dataInteractor.getContentById(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ content ->
                    _result.value = content
                }, { error ->

                })
                .autoDispose()
    }
}
