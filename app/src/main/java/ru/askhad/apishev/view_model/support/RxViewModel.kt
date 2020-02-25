package ru.askhad.apishev.view_model.support

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

open class RxViewModel : ViewModel(){
    private val compositeDisposable = CompositeDisposable()

    protected fun Disposable.autoDispose() = compositeDisposable.add(this)

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}
