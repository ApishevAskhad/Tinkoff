package ru.askhad.apishev.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.askhad.apishev.R

class NewsPreviewAdapter(val onItemClicked: (id: String?) -> Unit) :
        RecyclerView.Adapter<NewsPreviewViewHolder>() {

    private val itemList = mutableListOf<NewsPreviewModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsPreviewViewHolder {
        val holder = NewsPreviewViewHolder(LayoutInflater
                .from(parent.context)
                .inflate(R.layout.item_news_preview, parent, false))
        holder.itemView.setOnClickListener {
            val position = holder.adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                val model = itemList[position]
                onItemClicked(model.id)
            }
        }
        return holder
    }

    override fun getItemCount() = itemList.size

    override fun onBindViewHolder(holder: NewsPreviewViewHolder, position: Int) {
        holder.bind(itemList[position])
    }

    fun updateList(newItems: List<NewsPreviewModel>) {
        itemList.clear()
        itemList.addAll(newItems)
        notifyDataSetChanged()
    }
}
