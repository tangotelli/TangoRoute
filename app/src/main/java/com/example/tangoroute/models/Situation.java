package com.example.tangoroute.models;

import java.io.Serializable;

public class Situation implements Serializable {

    private String city;
    private String country;
    private Coordinates coordinates;

    public Situation(String city, String country, Coordinates coordinates) {
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

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    @Override
    public String toString() {
        return "Location{" +
                "city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", coordinates=" + coordinates.toString() +
                '}';
    }
}
