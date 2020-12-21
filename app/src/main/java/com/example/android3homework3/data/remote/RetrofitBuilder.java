package com.example.android3homework3.data.remote;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.android3homework3.data.remote.RetrofitApi;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@RequiresApi(api = Build.VERSION_CODES.O)
public class RetrofitBuilder {

    private static RetrofitApi retrofitApi;
    private static DateTimeFormatter formatter
            = DateTimeFormatter.ofPattern("uuuu-MM-dd HH:mm:ss");

    public static RetrofitApi getService(){
     if (retrofitApi == null){
         retrofitApi = getCurrentWeather();
     }
     return retrofitApi;
    }

    public static RetrofitApi getCurrentWeather(){
       return new Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RetrofitApi.class);
    }

    String dateString = "08:45:22";
    LocalDateTime dateTime = LocalDateTime.parse(dateString, formatter);
    String newString = dateTime.format(DateTimeFormatter.ISO_LOCAL_DATE);
    }
