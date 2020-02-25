package ru.askhad.apishev.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import ru.askhad.apishev.R
import ru.askhad.apishev.view_model.ContentViewModel

class ContentFragment : MVVMFragment<ContentViewModel>() {

    override val layoutId = R.layout.fr_content

    override fun createViewModel() = lazy {
        ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[ContentViewModel::class.java]
    }

    override fun observeLiveData() {

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }
}
