package com.example.android3homework3;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


import com.example.android3homework3.data.remote.RetrofitBuilder;
import com.example.android3homework3.data.remote.pojo.CurrentWeather;

import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView tvLocation, tvCurrent, tvCurrentShow, tvCurrentText, tvWeek, tvToday, tvTodayShowMax,
            tvTodayShowMin,
            tvTodayTextMax, tvTodayTextMin, tvWind, tvWindShow, tvPressure,
            tvPressureShow, tvHumidity, tvHumidityShow, tvSunrise, tvSunriseShow, tvCloudiness,
            tvCloudinessShow, tvSunset, tvSunsetShow;

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        getDataFromApi();


    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void getDataFromApi() {
        RetrofitBuilder.getCurrentWeather().getWeather("Bishkek", "fb32960db13f8d8b8c3d4ca298710f7c", "metric").enqueue(new Callback<CurrentWeather>() {
            @Override
            public void onResponse(Call<CurrentWeather> call, Response<CurrentWeather> response) {
                CurrentWeather weather = response.body();
                fillCurrentWeather(weather);
            }

            @Override
            public void onFailure(Call<CurrentWeather> call, Throwable t) {
                Log.d("TAG", "onFailure: ");
            }
        });
    }

    private void fillCurrentWeather(CurrentWeather weather) {
        tvCurrent.setText("Сейчас");
        tvCurrentShow.setText(weather.getMain().getTemp().toString());
        tvCurrentText.setText("little Clouds");
        tvTodayShowMax.setText(weather.getMain().getTempMax().toString());
        tvTodayShowMin.setText(weather.getMain().getTempMin().toString());
        tvTodayTextMax.setText("Max");
        tvTodayTextMin.setText("Min");
        tvWind.setText("Wind");
        tvWindShow.setText(weather.getWind().getSpeed().toString());
        tvPressure.setText("Pressure");
        tvPressureShow.setText(weather.getMain().getPressure().toString());
        tvHumidity.setText("Humidity");
        tvHumidityShow.setText(weather.getMain().getHumidity().toString());
        tvCloudiness.setText("Cloudiness");
        tvCloudinessShow.setText(weather.getClouds().getAll().toString());
        tvSunset.setText("Sunset");
        tvSunsetShow.setText(weather.getTimezone().toString());
        tvSunrise.setText("Sunrise");
        tvSunriseShow.setText(weather.getTimezone().toString());
        tvLocation.setText(weather.getName());
        
    }

    private void initViews() {
        tvLocation = findViewById(R.id.tv_location);
        tvCurrent = findViewById(R.id.tv_current);
        tvCurrentShow = findViewById(R.id.tv_current_show);
        tvCurrentText = findViewById(R.id.tv_current_text);
        tvWeek = findViewById(R.id.tv_week);
        tvToday = findViewById(R.id.tv_today);
        tvTodayShowMax = findViewById(R.id.tv_today_show);
        tvTodayTextMax = findViewById(R.id.tv_today_text_max);
        tvTodayTextMin = findViewById(R.id.tv_today_text_min);
        tvTodayShowMin = findViewById(R.id.tv_today_show_min);
        tvWind = findViewById(R.id.tv_wind);
        tvWindShow = findViewById(R.id.tv_wind_show);
        tvPressure = findViewById(R.id.tv_pressure);
        tvPressureShow = findViewById(R.id.tv_pressure_show);
        tvHumidity = findViewById(R.id.tv_humidity);
        tvHumidityShow = findViewById(R.id.tv_humidity_show);
        tvSunrise = findViewById(R.id.tv_sunrise);
        tvSunriseShow = findViewById(R.id.tv_sunrise_show);
        tvCloudiness = findViewById(R.id.tv_cloudiness);
        tvCloudinessShow = findViewById(R.id.tv_cloudiness_show);
        tvSunset = findViewById(R.id.tv_sunset);
        tvSunsetShow = findViewById(R.id.tv_sunset_show);
    }

}