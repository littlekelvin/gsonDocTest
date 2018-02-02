package com.oocl.common.utils;


public class GsonSerializerBuilder {
    public static GsonSerializer buildEntityUtilWithNoSkipField(){
        return new GsonSerializer(false, false, false);
    }

    public static GsonSerializer buildEntityUtilWithSkipAllRelatedField(){
        return new GsonSerializer(true, true, true);
    }

    public static GsonSerializer buildEntityUtil(boolean isSkipManyToOneField, boolean isSkipOneToOneField, boolean isSkipManyToManyField){
        return new GsonSerializer(isSkipManyToOneField, isSkipOneToOneField, isSkipManyToManyField);
    }
}
