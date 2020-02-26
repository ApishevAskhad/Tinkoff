package ru.askhad.apishev.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import ru.askhad.apishev.di.DataInteractor
import ru.askhad.apishev.fragment.NewsPreviewModel
import ru.askhad.apishev.state.NewsPreviewState
import ru.askhad.apishev.state.NewsPreviewState.Error
import ru.askhad.apishev.state.NewsPreviewState.Correct
import ru.askhad.apishev.view_model.support.RxViewModel
import java.text.SimpleDateFormat
import java.util.*
import javax.net.ssl.SSLHandshakeException

class NewsPreviewViewModel(
        private val dataInteractor: DataInteractor
) : RxViewModel() {
    private val modelList = mutableListOf<NewsPreviewModel>()
    private val _result = MutableLiveData<NewsPreviewState>()
    val result: LiveData<NewsPreviewState> = _result

    fun onLoadingData(update: Boolean? = false) {
        dataInteractor.getTitles()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map {list ->
                    list.sortedBy {
                        it.publicationDate?.milliseconds
                    }
                    list.forEach {title->
                        val date = Date(title.publicationDate?.milliseconds!!)

                        val model = NewsPreviewModel(
                                title.id,
                                title.text,
                                SimpleDateFormat("HH:mm dd MM yyyy").format(date)
                        )
                        modelList.add(model)
                    }
                }
                .subscribe({
                    _result.value = Correct(modelList)
                }, { error ->
                    when (error) {
                        is SSLHandshakeException -> _result.value = Error
                    }
                })
                .autoDispose()
    }
}
