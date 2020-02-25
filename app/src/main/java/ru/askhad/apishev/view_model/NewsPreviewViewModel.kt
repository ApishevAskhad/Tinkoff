package ru.askhad.apishev.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.askhad.apishev.di.DataInteractor
import ru.askhad.apishev.fragment.NewsPreviewModel
import ru.askhad.apishev.view_model.support.RxViewModel
import java.util.*

class NewsPreviewViewModel(
        private val dataInteractor: DataInteractor
) : RxViewModel() {
    private val modelList = mutableListOf<NewsPreviewModel>()
    private val _result = MutableLiveData<List<NewsPreviewModel>>()
    val result: LiveData<List<NewsPreviewModel>> = _result

    fun onLoadingData(update: Boolean? = false) {
        dataInteractor.getTitles()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map {list ->
                    list.forEach {title->
                        val currentTime = Calendar.getInstance()
                        val model = NewsPreviewModel(
                                title.id,
                                title.text,
                                title.publicationDate?.milliseconds.toString()
                        )
                        modelList.add(model)
                    }
                }
                .subscribe({
                    _result.value = modelList
                }, { error ->

                })
                .autoDispose()
    }
}
