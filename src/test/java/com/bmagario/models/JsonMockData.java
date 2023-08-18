package com.bmagario.models;



import com.google.common.io.Resources;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;

public class JsonMockData {

    public static List<Wine> getWines() throws IOException {
        InputStream inputStream = Resources.getResource("wines.json").openStream();
        String json = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        Type listType = new TypeToken<ArrayList<Wine>>() {}.getType();
        return new Gson().fromJson(json, listType);
    }

    public static List<Sommelier> getSommeliers() throws IOException {
        InputStream inputStream = Resources.getResource("sommeliers.json").openStream();
        String json = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        Type listType = new TypeToken<ArrayList<Sommelier>>() {}.getType();
        return new Gson().fromJson(json, listType);
    }

}