package com.example.tangoroute.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.tangoroute.R;
import com.example.tangoroute.connectivity.AirportAPIService;
import com.example.tangoroute.models.Situation;
import com.example.tangoroute.models.Wonder;
import com.example.tangoroute.pojo.AirportList;
import com.example.tangoroute.pojo.Location;
import com.example.tangoroute.utils.MyHttpClient;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class AirportActivity extends AppCompatActivity {

    private AirportList airports = new AirportList();
    private Wonder wonder;
    private ListView listView;
    private ListAdapter listAdapter;
    private AirportAPIService apiService;

    private static final String API_BASE_URL = "https://aerodatabox.p.rapidapi.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_airport);
        this.wonder = (Wonder) getIntent().getSerializableExtra(MainActivity.WONDER_BUNDLE_CODE);
        this.setUpRetrofit();
        this.getClosestAirports();
    }

    private void setUpRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(MyHttpClient.getUnsafeOkHttpClient())
                .build();
        apiService = retrofit.create(AirportAPIService.class);
    }

    private void getClosestAirports() {
        Call<AirportList> call_async = apiService
                .getClosestAirports(
                        this.wonder.getSituation().getCoordinates().getLatitude(),
                        this.wonder.getSituation().getCoordinates().getLongitude());
        call_async.enqueue(new Callback<AirportList>() {
            @Override
            public void onResponse(Call<AirportList> call, Response<AirportList> response) {
                airports = response.body();
                fillAirportsList();
            }

            @Override
            public void onFailure(Call<AirportList> call, Throwable t) {
                Snackbar.make(
                        findViewById(android.R.id.content),
                        "ERROR: " + t.getMessage(),
                        Snackbar.LENGTH_LONG
                ).show();
            }
        });
    }

    private void fillAirportsList() {
        this.listView = (ListView) findViewById(R.id.listAirport);
        this.listAdapter = new AirportListAdapter(this.airports, this.getResources(), this);
        this.listView.setAdapter(listAdapter);
    }

    public String getDistanceToWonder(Location airportLocation) {
        LatLng wonderLatLng = this.wonder.getSituation().getCoordinates().toLatLng();
        float[] results = new float[1];
        android.location.Location.distanceBetween(airportLocation.getLat(), airportLocation.getLon(),
                wonderLatLng.latitude, wonderLatLng.longitude, results);
        float distance = results[0] / 1000;
        return getString(R.string.distance_to_wonder)
                .replace("$", this.wonder.getName()) + String.format("%.2f", distance) + " km";
    }
}