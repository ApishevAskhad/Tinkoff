package ru.askhad.apishev.network;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;
import ru.askhad.apishev.model.Content;
import ru.askhad.apishev.model.Titles;

public interface TinkoffApi {
    @GET("news")
    Single<Titles> getNews();

    @GET("news_content")
    Single<Content> getContent(@Query(value = "id", encoded = true) String id);
}
