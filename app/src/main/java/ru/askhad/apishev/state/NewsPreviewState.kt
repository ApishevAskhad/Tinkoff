package ru.askhad.apishev.state

import ru.askhad.apishev.fragment.NewsPreviewModel

sealed class NewsPreviewState {
    object Error : NewsPreviewState()
    class Correct(val data: List<NewsPreviewModel>): NewsPreviewState()
}