package ru.askhad.apishev.fragment

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import ru.askhad.apishev.R
import ru.askhad.apishev.view_model.NewsPreviewViewModel
import ru.askhad.apishev.view_model.support.CustomViewModelFactory

class NewsPreviewFragment : MVVMFragment<NewsPreviewViewModel>() {

    override val layoutId = R.layout.fr_news_preview
    private val adapter = NewsPreviewAdapter(::onItemClicked)

    override fun createViewModel() = lazy {
        ViewModelProvider(this, CustomViewModelFactory())[NewsPreviewViewModel::class.java]
    }

    override fun observeLiveData() {
        viewModel.result.observe(this, Observer {

        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    }

    private fun onItemClicked(id: String?) {
        viewModel.onContent(id)
    }
}
