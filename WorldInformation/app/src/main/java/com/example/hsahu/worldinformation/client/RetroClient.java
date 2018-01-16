package com.example.hsahu.worldinformation.client;

import com.example.hsahu.worldinformation.dto.Country;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RetroClient {

    public static final String BASE_URL = "http://restcountries.eu/rest/v2/";

    @GET("all")
    Call<List<Country>> getAllCountries();

    @GET("region/{regionName}")
    Call<List<Country>> getAllCountriesByRegion();
}
