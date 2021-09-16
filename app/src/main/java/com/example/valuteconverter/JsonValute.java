package com.example.valuteconverter;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonValute {
    @GET("daily_json.js")
    Call<Example> getExample();
}
