package com.oocl.common.utils;

/**
 * Created by LIUMA4 on 11/15/2017.
 */
public class DBMockUtils {
    public static String getFileName(Class classObject, long oid){
        return classObject.getSimpleName() + oid + ".json";
    }

    public static String getFileName(Class classObject, String oid){
        return classObject.getSimpleName() + oid + ".json";
    }
}
