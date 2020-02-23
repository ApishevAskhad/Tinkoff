package ru.apishev.askhad.data.network

import com.facebook.stetho.okhttp3.StethoInterceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.tinkoff.ru/v1/"

interface TinkoffApi {
//    @GET("news")
//    fun getNews(): Single<List<Title>>

//    @GET("news_content")
//    fun getContentById(): Single<Content>

    companion object Factory {
        fun create(): TinkoffApi {
            val okHttpClient = OkHttpClient.Builder()
                    .addNetworkInterceptor(StethoInterceptor())
            val retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okHttpClient.build())
                    .build()
            return retrofit.create(TinkoffApi::class.java)
        }
    }
}
