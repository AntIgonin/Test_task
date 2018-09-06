package com.example.anton.myapplication.Classes;

import com.example.anton.myapplication.Interface.ServerApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    public static final String BASE_URL = "http://5b90e1cc3ef10a001445d113.mockapi.io/api/v1/";
    private static Retrofit retrofit = null;


    public static ServerApi getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(ServerApi.class);
    }
}
