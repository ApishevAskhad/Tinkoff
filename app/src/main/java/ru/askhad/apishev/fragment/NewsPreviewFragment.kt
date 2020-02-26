package ru.askhad.apishev.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fr_news_preview.*
import ru.askhad.apishev.R
import ru.askhad.apishev.fragment.support.CONTENT_ID_KEY
import ru.askhad.apishev.fragment.support.MVVMFragment
import ru.askhad.apishev.state.NewsPreviewState
import ru.askhad.apishev.state.NewsPreviewState.Error
import ru.askhad.apishev.state.NewsPreviewState.Correct
import ru.askhad.apishev.view_model.NewsPreviewViewModel
import ru.askhad.apishev.view_model.support.CustomViewModelFactory

class NewsPreviewFragment : MVVMFragment<NewsPreviewViewModel>() {

    override val layoutId = R.layout.fr_news_preview
    private val newsPreviewAdapter = NewsPreviewAdapter(::onItemClicked)

    override fun createViewModel() = lazy {
        ViewModelProvider(this, CustomViewModelFactory())[NewsPreviewViewModel::class.java]
    }

    override fun observeLiveData() {
        viewModel.result.observe(this, Observer { state ->
            when (state) {
                is Correct -> {
                    newsPreviewAdapter.updateList(state.data)
                }
                is Error -> {
                    Toast.makeText(requireContext(), "Error", Toast.LENGTH_LONG).show()
                }
            }
        })
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.onLoadingData()
        recycler.adapter = newsPreviewAdapter
        val layoutManager = LinearLayoutManager(requireContext())
        recycler.layoutManager = layoutManager
        val itemDecoration = DividerItemDecoration(requireContext(), layoutManager.orientation)
        itemDecoration.setDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.item_separator_news_preview)!!)
        recycler.addItemDecoration(itemDecoration)
    }

    private fun onItemClicked(id: String?) {
        val bundle = Bundle()
        bundle.putString(CONTENT_ID_KEY, id)
        val fragment = ContentFragment()
        fragment.arguments = bundle
        requireFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .addToBackStack(fragment.javaClass.name)
                .commit()
    }
}
