/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.sdk.core.keymanager.datamodel;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import org.omnione.did.sdk.datamodel.common.enums.AlgorithmType;

public class KeyGenerationInfo {
    @SerializedName("algoType")
    private AlgorithmType.ALGORITHM_TYPE algoType;

    @SerializedName("publicKey")
    private String publicKey;

    @SerializedName("privateKey")
    private String privateKey;

    public KeyGenerationInfo() {
    }

    public KeyGenerationInfo(String keyId, AlgorithmType.ALGORITHM_TYPE algoType, int storeType, String publicKey, String privateKey) {
        this.algoType = algoType;
        this.publicKey = publicKey;
        this.privateKey = privateKey;
    }

    public AlgorithmType.ALGORITHM_TYPE getAlgoType() {
        return algoType;
    }

    public void setAlgoType(AlgorithmType.ALGORITHM_TYPE algoType) {
        this.algoType = algoType;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String toJson(){
        Gson gson = new Gson();
        return gson.toJson(this);
    }

}
