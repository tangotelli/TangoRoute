package com.example.tangoroute.utils;

import android.util.Log;

import androidx.room.TypeConverter;

import com.example.tangoroute.models.Location;
import com.google.android.gms.maps.model.LatLng;

public class LocationConverter {

    private static final String SPLIT_CHAR = ";";

    @TypeConverter
    public static Location toLocation(String locationString) {
        if (locationString == null) {
            return null;
        } else {
            return deserialize(locationString);
        }
    }

    @TypeConverter
    public static String toLocationString(Location location) {
        if (location == null) {
            return null;
        } else {
            return serialize(location);
        }
    }

    private static String serialize(Location location) {
        String serialized = location.getCity() + SPLIT_CHAR;
        serialized += location.getCountry() + SPLIT_CHAR;
        serialized += location.getCoordinates().latitude + SPLIT_CHAR;
        serialized += location.getCoordinates().longitude + SPLIT_CHAR;
        return serialized;
    }

    private static Location deserialize(String locationString) {
        String[] deserializedParts = locationString.split(SPLIT_CHAR);
        LatLng coordinates = new LatLng(Double.parseDouble(deserializedParts[2]),
                Double.parseDouble(deserializedParts[3]));
        return new Location(deserializedParts[0],
                deserializedParts[1],
                coordinates);
    }
}
