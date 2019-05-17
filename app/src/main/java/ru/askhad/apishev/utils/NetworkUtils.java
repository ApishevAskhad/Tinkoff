package ru.askhad.apishev.utils;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.askhad.apishev.BuildConfig;
import ru.askhad.apishev.TinkoffApi;

public class NetworkUtils {
    private static NetworkUtils mInstance;
    private static Retrofit mRetrofit;

    private NetworkUtils() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.SERVER_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    public static NetworkUtils getInstance() {
        if (mInstance == null)
            mInstance = new NetworkUtils();
        return mInstance;
    }

    public TinkoffApi getTinkoffApi() {
        return mRetrofit.create(TinkoffApi.class);
    }
}
