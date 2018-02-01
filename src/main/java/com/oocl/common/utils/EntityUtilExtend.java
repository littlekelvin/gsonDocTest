package com.oocl.common.utils;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class EntityUtilExtend {
    private Gson gson;
    public static final String FILE_PATH_PREFIX = "./src/main/resources/resource/";

    private EntityUtilExtend(boolean isSkipManyToOneField, boolean isSkipOneToOneField, boolean isSkipManyToManyField) {
        this.gson = GsonFactory.buildGson(isSkipManyToOneField, isSkipOneToOneField, isSkipManyToManyField);
    }

    public static EntityUtilExtend buildEntityUtilWithNoSkipField(){
        return new EntityUtilExtend(false, false, false);
    }

    public static EntityUtilExtend buildEntityUtilWithSkipAllRelatedField(){
        return new EntityUtilExtend(true, true, true);
    }

    public static EntityUtilExtend buildEntityUtil(boolean isSkipManyToOneField, boolean isSkipOneToOneField, boolean isSkipManyToManyField){
        return new EntityUtilExtend(isSkipManyToOneField, isSkipOneToOneField, isSkipManyToManyField);
    }

    public void generateJsonFile(String filename, Object obj) throws IOException {
        String jsonString = gson.toJson(obj);
        FileUtils.writeStringToFile(new File(FILE_PATH_PREFIX + filename), jsonString, Charset.defaultCharset());
    }

    public <T> T generateObjFromJsonFile(String filename, Class<T> clazz) throws IOException {
        String jsonString = FileUtils.readFileToString(new File(FILE_PATH_PREFIX + filename), Charset.defaultCharset());
        return gson.fromJson(jsonString, clazz);
    }
    public JSONObject generateJSONObjectFromJsonFile(String filename) throws IOException {
        String jsonString = FileUtils.readFileToString(new File(FILE_PATH_PREFIX + filename), Charset.defaultCharset());
        return JSONObject.parseObject(jsonString);
    }

    public <T> T generateObjectFromJsonObject(JSONObject jsonObject, Class<T> clazz) throws IOException {
        String jsonString = jsonObject.toJSONString();
        return gson.fromJson(jsonString, clazz);
    }
}
