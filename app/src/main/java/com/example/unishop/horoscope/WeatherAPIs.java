package com.example.unishop.horoscope;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface WeatherAPIs {



    @GET("/theastrologer/api/horoscope/{sunsign}/today/")
    Call< WResponse > getHoroscope(@Path("sunsign") String Sunsign);
}

