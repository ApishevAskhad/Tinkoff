package ru.askhad.apishev.network;

import java.net.ConnectException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import ru.askhad.apishev.BuildConfig;

public class NetworkUtils {
    public static final List<Class<?>> NETWORK_EXCEPTIONS = Arrays.asList(
            UnknownHostException.class,
            SocketTimeoutException.class,
            ConnectException.class
    );
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
