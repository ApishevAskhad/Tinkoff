package ru.askhad.apishev.recycler;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import ru.askhad.apishev.R;
import ru.askhad.apishev.model.Title;

public class NewsHolder extends RecyclerView.ViewHolder {
    private TextView mTitle;

    public NewsHolder(@NonNull View itemView) {
        super(itemView);
        mTitle = itemView.findViewById(R.id.tv_title);
    }

    public void bind(Title item) {
        mTitle.setText(item.getText());
    }

    public void setListener(NewsAdapter.OnItemClickListener listener) {
        itemView.setOnClickListener(v -> listener.onItemClick());
    }
}
