package ru.askhad.apishev.fragment

import android.os.Bundle
import androidx.core.text.HtmlCompat
import androidx.core.text.HtmlCompat.FROM_HTML_MODE_LEGACY
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.fr_content.*
import ru.askhad.apishev.R
import ru.askhad.apishev.fragment.support.CONTENT_ID_KEY
import ru.askhad.apishev.fragment.support.MVVMFragment
import ru.askhad.apishev.view_model.ContentViewModel
import ru.askhad.apishev.view_model.support.CustomViewModelFactory

class ContentFragment : MVVMFragment<ContentViewModel>() {

    override val layoutId = R.layout.fr_content
    private lateinit  var contentId : String

    override fun createViewModel() = lazy {
        ViewModelProvider(this, CustomViewModelFactory())[ContentViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (arguments != null) {
            contentId = arguments!!.getString(CONTENT_ID_KEY, "")
            viewModel.onContentLoad(contentId)
        } else {
            //TODO handle this
        }
    }

    override fun observeLiveData() {
        viewModel.result.observe(this, Observer { content ->
            tv_content.text = HtmlCompat.fromHtml(content.content!!, FROM_HTML_MODE_LEGACY)
        })
    }
}
