/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.sdk.utility.DataModels;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EcKeyPair {
    @SerializedName("ecType")
    @Expose
    private EcType.EC_TYPE ecType;
    @SerializedName("privateKey")
    @Expose
    private String privateKey;
    @SerializedName("publicKey")
    @Expose
    private String publicKey;

    public EcKeyPair() {
    }

    public EcKeyPair(String keyId, EcType.EC_TYPE ecType, int storeType, String publicKey, String privateKey) {
        this.ecType = ecType;
        this.publicKey = publicKey;
        this.privateKey = privateKey;
    }

    public EcType.EC_TYPE getEcType() {
        return ecType;
    }

    public void setEcType(EcType.EC_TYPE ecType) {
        this.ecType = ecType;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String toJson(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }

}
