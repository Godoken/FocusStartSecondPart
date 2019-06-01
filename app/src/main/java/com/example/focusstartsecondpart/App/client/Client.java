package com.example.focusstartsecondpart.App.client;


import com.example.focusstartsecondpart.BuildConfig;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Client {

    private static Client instance = new Client();

    private static Api api;

    private static final String BASE_URL = "https://team.cft.ru/";
    private static final String CFT_TEST_TOKEN = "cftte@mtest20!9";

    public static Client getInstance(){
        return instance;
    }

    private Client(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel((BuildConfig.DEBUG) ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE))
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        api = retrofit.create(Api.class);
    }

    public Api getApi(){
        return api;
    }

    public String getCftToken(){
        return CFT_TEST_TOKEN;
    }
}
