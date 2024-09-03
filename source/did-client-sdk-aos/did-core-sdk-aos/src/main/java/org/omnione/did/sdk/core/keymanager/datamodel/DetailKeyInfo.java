/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.sdk.core.keymanager.datamodel;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.omnione.did.sdk.datamodel.common.BaseObject;

public class DetailKeyInfo extends BaseObject {
    @SerializedName("id")
    @Expose
    private String id; // keyId

    @SerializedName("privateKey")
    @Expose
    private String privateKey;

    @SerializedName("salt")
    @Expose
    private String salt;
    public DetailKeyInfo(){}
    public DetailKeyInfo(String id) {
        this.id = id;
    }
    public DetailKeyInfo(String id, String privateKey) {
        this.id = id;
        this.privateKey = privateKey;
    }
    public DetailKeyInfo(String id, String privateKey, String salt) {
        this.id = id;
        this.privateKey = privateKey;
        this.salt = salt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public void fromJson(String val) {
        Gson gson = new Gson();
        DetailKeyInfo obj = gson.fromJson(val, DetailKeyInfo.class);

        id = obj.getId();
        salt = obj.getSalt();
        privateKey = obj.getPrivateKey();

    }
}
