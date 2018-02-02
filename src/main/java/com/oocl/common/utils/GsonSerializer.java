package com.oocl.common.utils;

import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class GsonSerializer {
    private Gson gson;
    public static final String FILE_PATH_PREFIX = "D:/resources/";

    public GsonSerializer(boolean isSkipManyToOneField, boolean isSkipOneToOneField, boolean isSkipManyToManyField) {
        this.gson = GsonFactory.buildGson(isSkipManyToOneField, isSkipOneToOneField, isSkipManyToManyField);
    }

    public void generateJsonFile(String filename, Object obj) throws IOException {
        String jsonString = gson.toJson(obj);
        FileUtils.writeStringToFile(new File(FILE_PATH_PREFIX + filename), jsonString, Charset.defaultCharset());
    }
}
