package ru.askhad.apishev.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.askhad.apishev.view_model.support.RxViewModel

class ActivityViewModel : RxViewModel() {
    private val _result = MutableLiveData<Boolean>()
    val result: LiveData<Boolean> = _result

    fun checkInternetConnection() {

    }
}