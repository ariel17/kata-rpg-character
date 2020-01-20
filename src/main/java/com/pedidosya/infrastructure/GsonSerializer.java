package com.pedidosya.infrastructure;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonSerializer {
    private static Gson gson = new GsonBuilder().create();

    public static Gson getGson() {
        return gson;
    }
}
