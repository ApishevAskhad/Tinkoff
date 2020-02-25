package ru.askhad.apishev.view_model.support

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import ru.askhad.apishev.di.ServiceLocator
import ru.askhad.apishev.view_model.NewsPreviewViewModel

class CustomViewModelFactory : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when (modelClass) {
            NewsPreviewViewModel::class.java -> NewsPreviewViewModel(
                ServiceLocator.dataInteractor
            ) as T
            else -> throw IllegalArgumentException("ViewModel is not found")
        }
    }
}
