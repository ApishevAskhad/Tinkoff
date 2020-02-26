package ru.apishev.askhad.data.network

import com.facebook.stetho.okhttp3.StethoInterceptor
import io.reactivex.Observable
import io.reactivex.Single
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import ru.apishev.askhad.data.network.dto.ContentDto
import ru.apishev.askhad.data.network.dto.TitleDto

private const val BASE_URL = "https://api.tinkoff.ru/v1/"

interface TinkoffApi {
    @GET("news")
    fun getNews(): Observable<List<TitleDto>>

    @GET("news_content")
    fun getContentById(@Query("id") id: String): Observable<ContentDto>

    companion object Factory {
        fun create(): TinkoffApi {
            val okHttpClient = OkHttpClient.Builder()
                    .addNetworkInterceptor(StethoInterceptor())
                    .build()
            val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(TinkoffConverter())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okHttpClient)
                    .build()
            return retrofit.create(TinkoffApi::class.java)
        }
    }
}
