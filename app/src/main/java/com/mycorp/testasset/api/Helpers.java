package com.mycorp.testasset.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Helpers {
    public static final String URL = "https://fakestoreapi.com/";

    public static Retrofit client(String base_url){
        Retrofit client = new Retrofit.Builder()
                .baseUrl(base_url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return client;
    }
}
