package ru.askhad.apishev.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ActivityViewModel : ViewModel() {
    private val _result = MutableLiveData<Boolean>()
    val result: LiveData<Boolean> = _result

    fun checkInternetConnection() {

    }
}