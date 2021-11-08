package com.example.tangoroute.utils;

import androidx.room.TypeConverter;

public class AnswerOptionsConverter {

    private static final String SPLIT_CHAR = ";";

    @TypeConverter
    public static String[] toArray(String optionsString) {
        if (optionsString == null) {
            return null;
        } else {
            return deserialize(optionsString);
        }
    }

    @TypeConverter
    public static String toString(String[] options) {
        if (options == null) {
            return null;
        } else {
            return serialize(options);
        }
    }

    private static String serialize(String[] options) {
        String serialized = "";
        for (int i = 0; i < options.length; i++) {
            serialized += options[i];
            if (i != options.length - 1) {
                serialized += SPLIT_CHAR;
            }
        }
        return serialized;
    }

    private static String[] deserialize(String optionsString) {
        return optionsString.split(SPLIT_CHAR);
    }
}
