package com.example.tangoroute.models;

import java.util.ArrayList;
import java.util.List;

public class Record {

    private String username;
    private int points;

    public Record(String username, int points) {
        this.username = username;
        this.points = points;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
