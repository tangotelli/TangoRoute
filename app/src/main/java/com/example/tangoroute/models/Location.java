package com.example.tangoroute.models;

import com.google.android.gms.maps.model.LatLng;

public class Location {

    private String city;
    private String country;
    private LatLng coordinates;

    public Location(String city, String country, LatLng coordinates) {
        this.city = city;
        this.country = country;
        this.coordinates = coordinates;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LatLng getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(LatLng coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return "Location{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", latitude=" + coordinates.latitude +
                ", longitude=" + coordinates.longitude +
                '}';
    }
}
