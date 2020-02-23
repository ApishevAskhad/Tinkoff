package ru.askhad.apishev.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ru.askhad.apishev.App;
import ru.askhad.apishev.R;
import ru.askhad.apishev.db.NewsDao;
import ru.askhad.apishev.network.NetworkUtils;
import ru.askhad.apishev.recycler.NewsAdapter;

public class RecyclerFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    private RecyclerView mRecycler;
    private SwipeRefreshLayout mRefresher;
    private NewsAdapter.OnItemClickListener mListener;

    @NonNull
    private final NewsAdapter mNewsAdapter = new NewsAdapter();

    public static RecyclerFragment newInstance() {
        return new RecyclerFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof NewsAdapter.OnItemClickListener)
            mListener = (NewsAdapter.OnItemClickListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fr_recycler, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mRecycler = view.findViewById(R.id.recycler);
        mRefresher = view.findViewById(R.id.refresher);
        mRefresher.setOnRefreshListener(this);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecycler.setAdapter(mNewsAdapter);
        mNewsAdapter.setListener(mListener);
        onRefresh();
    }

    @Override
    public void onRefresh() {
        mRefresher.post(this::loadTitles);
    }

    @SuppressLint("CheckResult")
    private void loadTitles() {
        NetworkUtils.getInstance()
                .getTinkoffApi()
                .getNews()
                .subscribeOn(Schedulers.io())
                /*
                //TODO sort data by publication_date
                //TODO write data into Room database on success response
                .doOnSuccess(titles -> getNewsDao().insertTitles(titles.getTitles()))
                //TODO read data from Room database on error
                .onErrorReturn(throwable -> {
                    if (NetworkUtils.NETWORK_EXCEPTIONS.contains(throwable.getClass())) {
                        Titles titles = new Titles();
                        titles.setTitles(getNewsDao().getTitles());
                        return titles;
                    } else {
                        return null;
                    }
                })
                */
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe(disposable -> mRefresher.setRefreshing(true))
                .doFinally(() -> mRefresher.setRefreshing(false))
                .subscribe(titles -> {
                    mNewsAdapter.addTitles(titles.getTitles(), true);
                    //TODO get content from server and store it into Room database
                });
    }

    @Override
    public void onDetach() {
        mListener = null;
        super.onDetach();
    }

    private NewsDao getNewsDao() {
        return ((App) getActivity().getApplication()).getDb().getTitlesDao();
    }
}
