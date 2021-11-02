package com.example.tangoroute.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.tangoroute.R;
import com.example.tangoroute.models.Wonder;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class DetailActivity extends AppCompatActivity implements OnMapReadyCallback {

    private Wonder wonder;
    private GoogleMap map;

    private static final float STREETS_ZOOM_LEVEL = 15;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.minimap);
        mapFragment.getMapAsync(this);
        TextView tvWonderName = findViewById(R.id.tvWonderName);
        tvWonderName.setText(getString(R.string.loading_map));
        this.wonder = (Wonder) getIntent().getSerializableExtra(MainActivity.WONDER_BUNDLE_CODE);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {
        this.map = googleMap;
        this.setUpInterface();
    }

    private void setUpInterface() {
       this.setTexts();
       this.setMap();
    }

    private void setTexts() {
        TextView tvWonderName = findViewById(R.id.tvWonderName);
        tvWonderName.setText(this.wonder.getName());
        TextView tvWonderDetail = findViewById(R.id.tvWonderDetail);
        tvWonderDetail.setText(this.wonder.getDescription());
    }

    private void setMap() {
        LatLng latLng = new LatLng(this.wonder.getSituation().getCoordinates().getLatitude(),
                this.wonder.getSituation().getCoordinates().getLongitude());
        Marker marker = this.map.addMarker(new MarkerOptions().position(latLng));
        marker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_VIOLET));
        this.map.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, STREETS_ZOOM_LEVEL));
    }
}