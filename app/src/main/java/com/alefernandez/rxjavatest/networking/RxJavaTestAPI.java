package com.alefernandez.rxjavatest.networking;

import android.content.Context;

import java.io.File;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;
import retrofit2.RxJavaCallAdapterFactory;

/**
 * Created by alejandro on 30/4/16.
 */
public class RxJavaTestAPI {

    private static RestAPI mApiInterface;

    //private constructor, so it can not be instantiated
    private RxJavaTestAPI(){};

    public static RestAPI getApiInterface(Context aContext) {

        if (mApiInterface == null) createInstance(aContext);
        return mApiInterface;
    }

    private static void createInstance(Context aContext) {
        synchronized (RxJavaTestAPI.class) {
            if (mApiInterface == null) {
                mApiInterface = buildApiClient(aContext);
            }

        }
    }

    private static RestAPI buildApiClient(Context aContext) {
        OkHttpClient.Builder lBuilder = new OkHttpClient.Builder();
        lBuilder.cache(createCache(aContext));

        OkHttpClient lClient = lBuilder.build();

        Retrofit lRetrofit = new Retrofit.Builder()
                .baseUrl(RestAPI.API_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(lClient)
                .build();

        return lRetrofit.create(RestAPI.class);

    }


    private static Cache createCache(Context aContext) {
        File lHttpCacheDirectory = new File(aContext.getApplicationContext()
                .getCacheDir().getAbsolutePath(), "HttpCache");
        return new Cache(lHttpCacheDirectory, 10 * 1024);
    }
}
