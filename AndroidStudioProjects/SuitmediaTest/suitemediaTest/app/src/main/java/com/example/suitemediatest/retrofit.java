package com.example.suitemediatest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class retrofit {

    private static final String BASE_URL = "https://reqres.in/api/";
    private static Retrofit retrofit = null;

    public static Api getRetrofitClient() {

        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit.create(Api.class);
    }

}
