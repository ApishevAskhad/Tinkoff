package ru.askhad.apishev;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import ru.askhad.apishev.model.News;

public class NewsHolder extends RecyclerView.ViewHolder {
    private TextView mTitle;

    public NewsHolder(@NonNull View itemView) {
        super(itemView);
        mTitle = itemView.findViewById(R.id.tv_title);
    }

    public void bind(News .PayloadBean item) {
        mTitle.setText(item.getText());
    }
}
