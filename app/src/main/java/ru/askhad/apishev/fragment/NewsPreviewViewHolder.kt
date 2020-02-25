package ru.askhad.apishev.fragment

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_news_preview.view.*

data class NewsPreviewModel(
        val id: String? = "",
        val title: String? = "",
        val timestamp: String? = ""
)

class NewsPreviewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    fun bind(model: NewsPreviewModel) {
        with(itemView) {
            tv_title.text = model.title
            tv_timestamp.text = model.timestamp
        }
    }
}