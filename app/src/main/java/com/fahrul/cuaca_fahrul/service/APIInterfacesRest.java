package com.fahrul.cuaca_fahrul.service;

import com.fahrul.cuaca_fahrul.model.Cuaca;
import com.fahrul.cuaca_fahrul.model.Cuacaone;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterfacesRest {

    @GET("forecast")
    Call<Cuacaone> getForecastByCity(@Query("q") String q, @Query("appid") String appid);
    @GET("onecall")
    Call<Cuaca> getForecastBylatlon(@Query("lat") Double lat, @Query("lon") Double lon, @Query("exclude") String exclude, @Query("units") String units, @Query("appid") String appid);

}
