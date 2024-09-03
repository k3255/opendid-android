/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.sdk.core.keymanager.datamodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.omnione.did.sdk.datamodel.common.enums.AlgorithmType;

public class WalletKeyGenRequest extends KeyGenRequest {
    @SerializedName("walletMethodType")
    @Expose
    private KeyGenWalletMethodType walletMethodType;

    public WalletKeyGenRequest() {}

    public WalletKeyGenRequest(String id, AlgorithmType.ALGORITHM_TYPE algoType, StorageOption.STORAGE_OPTION storageOption, KeyGenWalletMethodType walletMethodType) {
        super(id, algoType, storageOption);
        this.walletMethodType = walletMethodType;
    }

    public KeyGenWalletMethodType getWalletMethodType() {
        return walletMethodType;
    }

    public void setWalletMethodType(KeyGenWalletMethodType walletMethodType) {
        this.walletMethodType = walletMethodType;
    }
}
