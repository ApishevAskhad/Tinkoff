package ru.askhad.apishev;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ru.askhad.apishev.model.News;

public class NewsAdapter extends RecyclerView.Adapter<NewsHolder> {
    @NonNull
    private final List<News.PayloadBean> mNews = new ArrayList<>();

    @Override
    public NewsHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.news_item, viewGroup, false);
        return new NewsHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsHolder newsHolder, int i) {
        News.PayloadBean payloadBean = mNews.get(i);
        newsHolder.bind(payloadBean);
    }

    @Override
    public int getItemCount() {
        return mNews.size();
    }

    public void addNews(List<News.PayloadBean> news, boolean isRefreshed) {
        if (isRefreshed)
            mNews.clear();
        mNews.addAll(news);
        notifyDataSetChanged();
    }
}
