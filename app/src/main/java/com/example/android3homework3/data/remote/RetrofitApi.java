package com.example.android3homework3.data.remote;

import com.example.android3homework3.data.remote.pojo.CurrentWeather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitApi {

    @GET("data/2.5/weather")
    Call<CurrentWeather> getWeather(@Query("q") String cityName, @Query("appid") String apiKey, @Query("units") String metric);
}
//http://api.openweathermap.org/data/2.5/weather?q=London&appid=fb32960db13f8d8b8c3d4ca298710f7c