package ru.askhad.apishev;

import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import ru.askhad.apishev.model.Content;
import ru.askhad.apishev.model.News;

public interface TinkoffApi {
    @GET("news")
    Single<News> getNews();

    @GET("news_content?id={id}")
    Call<Content> getContent(@Path("id") int id);
}
