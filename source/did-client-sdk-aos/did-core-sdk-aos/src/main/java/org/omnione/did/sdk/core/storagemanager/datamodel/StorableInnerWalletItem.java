/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.sdk.core.storagemanager.datamodel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.omnione.did.sdk.datamodel.util.IntEnumAdapterFactory;
import org.omnione.did.sdk.datamodel.util.JsonSortUtil;
import org.omnione.did.sdk.datamodel.util.StringEnumAdapterFactory;

public class StorableInnerWalletItem<M extends Meta> {
    M meta;
    String item;

    public M getMeta() {
        return meta;
    }

    public void setMeta(M meta) {
        this.meta = meta;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public <T> void fromJson(String val, Class<T> clazz) {
        Gson gson = new Gson();
        TypeToken<StorableInnerWalletItem<M>> typeToken = new TypeToken<StorableInnerWalletItem<M>>() {};
        StorableInnerWalletItem<M> obj = gson.fromJson(val, typeToken.getType());
        this.meta = obj.getMeta();
        this.item = obj.getItem();
    }
    public String toJson() {
        //GsonWrapper gson = new GsonWrapper();
        Gson gson = new GsonBuilder()
                .registerTypeAdapterFactory(new IntEnumAdapterFactory())
                .registerTypeAdapterFactory(new StringEnumAdapterFactory())
                .disableHtmlEscaping()
                .create();
        String json = gson.toJson(this);
        return JsonSortUtil.sortJsonString(gson, json);
    }
}
