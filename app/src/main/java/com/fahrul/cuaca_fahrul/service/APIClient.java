package com.fahrul.cuaca_fahrul.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {

    public static String BASE_URL ="https://api.openweathermap.org/data/2.5/";

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {



            OkHttpClient client = new OkHttpClient.Builder().build();
            GsonBuilder gb = new GsonBuilder();
            gb.registerTypeAdapter(String.class, new StringConverter());
            gb.serializeNulls();

            Gson gson = gb.create();


            retrofit = new Retrofit.Builder()
                    .baseUrl(APIClient.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))

                    .client(client)
                    .build();



            return retrofit;
        }



}
