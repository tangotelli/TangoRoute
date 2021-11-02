package com.example.tangoroute.utils;

import androidx.room.TypeConverter;

import com.example.tangoroute.models.Coordinates;
import com.example.tangoroute.models.Situation;

public class LocationConverter {

    private static final String SPLIT_CHAR = ";";

    @TypeConverter
    public static Situation toLocation(String locationString) {
        if (locationString == null) {
            return null;
        } else {
            return deserialize(locationString);
        }
    }

    @TypeConverter
    public static String toLocationString(Situation situation) {
        if (situation == null) {
            return null;
        } else {
            return serialize(situation);
        }
    }

    private static String serialize(Situation situation) {
        String serialized = situation.getCity() + SPLIT_CHAR;
        serialized += situation.getCountry() + SPLIT_CHAR;
        serialized += situation.getCoordinates().getLatitude() + SPLIT_CHAR;
        serialized += situation.getCoordinates().getLongitude() + SPLIT_CHAR;
        return serialized;
    }

    private static Situation deserialize(String locationString) {
        String[] deserializedParts = locationString.split(SPLIT_CHAR);
        Coordinates coordinates = new Coordinates(Double.parseDouble(deserializedParts[2]),
                Double.parseDouble(deserializedParts[3]));
        return new Situation(deserializedParts[0],
                deserializedParts[1],
                coordinates);
    }
}
