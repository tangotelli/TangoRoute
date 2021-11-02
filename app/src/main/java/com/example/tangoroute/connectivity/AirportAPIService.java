package com.example.tangoroute.connectivity;

import com.example.tangoroute.pojo.AirportList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface AirportAPIService {

    @Headers({
            "x-rapidapi-host: aerodatabox.p.rapidapi.com",
            "x-rapidapi-key: c80a273ebcmsh1037adddc01d6c8p157babjsn0955b373c467"
    })
    @GET("/airports/search/location/{latitude}/{longitude}/km/100/10")
    Call<AirportList> getClosestAirports(@Path("latitude") double latitude,
                                         @Path("longitude") double longitude);
}
