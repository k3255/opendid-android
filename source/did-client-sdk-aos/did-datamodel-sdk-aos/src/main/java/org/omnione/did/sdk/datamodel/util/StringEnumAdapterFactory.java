/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.sdk.datamodel.util;


import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class StringEnumAdapterFactory implements TypeAdapterFactory {
    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        Class<? super T> rawType = type.getRawType();
        if (!StringEnum.class.isAssignableFrom(rawType) || !Enum.class.isAssignableFrom(rawType)) {
            return null; // Only handle StringEnum enums
        }

        return (TypeAdapter<T>) new TypeAdapter<StringEnum>() {

            @Override
            public void write(JsonWriter out, StringEnum value) throws IOException {
                //Log.d("test", "String enum write : " + value + " / " + rawType);
                out.value(value.getValue());
            }

            @Override
            public StringEnum read(JsonReader in) throws IOException {
                String value = in.nextString();
                Method fromValueMethod;
                try {
                    fromValueMethod = rawType.getMethod("fromValue", String.class);
                    return (StringEnum) fromValueMethod.invoke(null, value);
                } catch (NoSuchMethodException | IllegalAccessException |
                         InvocationTargetException e) {
                    throw new IOException("Failed to deserialize enum", e);
                }
            }
        };
    }
}