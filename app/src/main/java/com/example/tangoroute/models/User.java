package com.example.tangoroute.models;

import com.example.tangoroute.utils.WonderGenerator;

import java.util.Iterator;
import java.util.Map;

public class User {

    private String email;
    private int points;
    private Map<String, Boolean> completedQuizes;
    private static User user;

    private static final int NUMBER_OF_WONDERS = 7;

    private User() {
        this.email = "";
        this.points = 0;
        this.completedQuizes = WonderGenerator.emptyHashMap();
    }

    public static User getInstance() {
        if (user == null) {
            user = new User();
        }
        return user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Map<String, Boolean> getCompletedQuizes() {
        return completedQuizes;
    }

    public void setCompletedQuizes(Map<String, Boolean> completedQuizes) {
        this.completedQuizes = completedQuizes;
    }

    public boolean hasCompletedQuizes() {
        Iterator iterator = this.completedQuizes.keySet().iterator();
        while (iterator.hasNext()) {
            Boolean value = this.completedQuizes.get(iterator.next());
            if (!value) {
                return false;
            }
        }
        return true;
    }
}
