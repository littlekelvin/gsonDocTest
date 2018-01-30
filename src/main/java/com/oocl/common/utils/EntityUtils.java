package com.oocl.common.utils;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.io.FileUtils;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import java.io.File;
import java.io.IOException;

public class EntityUtils {
    public static final Gson gson = buildGson();

    public static final String FILE_PATH_PREFIX = "../ARP_Domain/resource/";

    public static Gson buildGson() {
        return new GsonBuilder().addSerializationExclusionStrategy(getExclusionStrategy()).setPrettyPrinting().create();
    }

    private static ExclusionStrategy getExclusionStrategy() {

        ExclusionStrategy exlStrategy = new ExclusionStrategy() {
            public boolean shouldSkipField(FieldAttributes fieldAttributes) {
                return (null != fieldAttributes.getAnnotation(ManyToOne.class)
                        || null != fieldAttributes.getAnnotation(OneToOne.class)
                        || null != fieldAttributes.getAnnotation(ManyToMany.class));
            }

            public boolean shouldSkipClass(Class<?> aClass) {
                return (null != aClass.getAnnotation(ManyToOne.class)
                        || null != aClass.getAnnotation(OneToOne.class)
                        || null != aClass.getAnnotation(ManyToMany.class));
            }
        };
        return exlStrategy;
    }

    public static void generateJsonFile(String filename, Object obj) throws IOException {
        String jsonString = gson.toJson(obj);
        FileUtils.writeStringToFile(new File(FILE_PATH_PREFIX + filename), jsonString);
    }

    public static <T> T generateObjFromJsonFile(String filename, Class<T> clazz) throws IOException {
        String jsonString = FileUtils.readFileToString(new File(FILE_PATH_PREFIX + filename));
        return gson.fromJson(jsonString, clazz);
    }
    public static JSONObject generateJSONObjectFromJsonFile(String filename) throws IOException {
        String jsonString = FileUtils.readFileToString(new File(FILE_PATH_PREFIX + filename));
        return JSONObject.parseObject(jsonString);
    }

    public static <T> T generateObjectFromJsonObject(JSONObject jsonObject, Class<T> clazz) throws IOException {
        String jsonString = jsonObject.toJSONString();
        return gson.fromJson(jsonString, clazz);
    }
}
