/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.sdk.core.storagemanager.datamodel;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.omnione.did.sdk.datamodel.util.IntEnumAdapterFactory;
import org.omnione.did.sdk.datamodel.util.JsonSortUtil;
import org.omnione.did.sdk.datamodel.util.StringEnumAdapterFactory;

public class ExternalWallet<T> {
    boolean isEncrypted;
    String data;
    int version;
    String signature; //signature

    public ExternalWallet() {

    }

    public ExternalWallet(boolean isEncrypted, String data) {
        this.isEncrypted = isEncrypted;
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public boolean isEncrypted() {
        return isEncrypted;
    }

    public void setEncryption(boolean setEncryption) {
        this.isEncrypted = setEncryption;
    }

    public void setEncrypted(boolean encrypted) {
        isEncrypted = encrypted;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public void fromJson(String val){
        Gson gson = new GsonBuilder()
                 .registerTypeAdapterFactory(new IntEnumAdapterFactory())
                .registerTypeAdapterFactory(new StringEnumAdapterFactory())
                .disableHtmlEscaping()
                .create();
        ExternalWallet<T> obj = gson.fromJson(val, ExternalWallet.class);

        isEncrypted = obj.isEncrypted();
        data = obj.getData();
        signature = obj.getSignature();
    }
    public String toJson(){
        Gson gson = new GsonBuilder()
                .registerTypeAdapterFactory(new IntEnumAdapterFactory())
                .registerTypeAdapterFactory(new StringEnumAdapterFactory())
                .disableHtmlEscaping()
                .create();
        String json = gson.toJson(this);
        return JsonSortUtil.sortJsonString(gson,json);
    }
}
