/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.sdk.datamodel.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import org.omnione.did.sdk.datamodel.util.IntEnumAdapterFactory;
import org.omnione.did.sdk.datamodel.util.StringEnumAdapterFactory;

public class MessageUtil {

    public static <T> T deserializeFromJsonElement(JsonElement jsonElement, Class<T> clazz) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapterFactory(new IntEnumAdapterFactory())
                .registerTypeAdapterFactory(new StringEnumAdapterFactory())
                .create();
        return gson.fromJson(jsonElement, clazz);
    }

    public static <T> T deserialize(String jsonString, Class<T> clazz) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapterFactory(new IntEnumAdapterFactory())
                .registerTypeAdapterFactory(new StringEnumAdapterFactory())
                .create();
        return gson.fromJson(jsonString, clazz);
    }

    public static <T> String serialize(Class<T> clazz) {
        Gson gson = new GsonBuilder()
                .registerTypeAdapterFactory(new IntEnumAdapterFactory())
                .registerTypeAdapterFactory(new StringEnumAdapterFactory())
                .create();

        return gson.toJson(clazz);
    }

}
