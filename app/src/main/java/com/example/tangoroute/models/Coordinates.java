package com.example.tangoroute.models;

import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;

public class Coordinates implements Serializable {

    private double latitude;
    private double longitude;

    public Coordinates(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "(" + latitude +
                ", " + longitude +
                ')';
    }

    public LatLng toLatLng() {
        return new LatLng(this.latitude, this.longitude);
    }
}
