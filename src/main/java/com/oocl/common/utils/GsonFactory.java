package com.oocl.common.utils;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonFactory {

    public static Gson buildGson(boolean isSkipManyToOneField, boolean isSkipOneToOneField, boolean isSkipManyToManyField){
        return new GsonBuilder().addSerializationExclusionStrategy(getExclusionStrategy(isSkipManyToOneField, isSkipOneToOneField, isSkipManyToManyField)).setPrettyPrinting().create();
    }

    private static ExclusionStrategy getExclusionStrategy(boolean isSkipManyToOneField, boolean isSkipOneToOneField, boolean isSkipManyToManyField){
        return new DocExclusionStrategy(isSkipManyToOneField, isSkipOneToOneField, isSkipManyToManyField);
    };
}
