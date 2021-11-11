package com.example.tangoroute.models;

import com.example.tangoroute.utils.WonderGenerator;

import java.util.Iterator;
import java.util.Map;

public class User {

    private String email;
    private int points;
    private Map<String, Boolean> completedQuizes;
    private static User user;

    public static final String USER_DATA_FILE = "tangoRouteUserScore.txt";

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

    public String serialize() {
        String serialized = "";
        Iterator iterator = this.completedQuizes.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Boolean> entry = (Map.Entry<String, Boolean>) iterator.next();
            serialized += entry.getKey() + "-" + entry.getValue() + ";";
        }
        serialized += this.points;
        return serialized;
    }

    public void deserialize(String serialized) {
        String[] serializedParts = serialized.split(";");
        this.points = Integer.parseInt(serializedParts[serializedParts.length - 1]
                .replace("\n", "").replace("\r", ""));
        for (int i = 0; i < serializedParts.length - 1; i++) {
            String[] serializedKeyValue = serializedParts[i].split("-");
            this.completedQuizes.replace(serializedKeyValue[0], Boolean.valueOf(serializedKeyValue[1]));
        }
    }
}
