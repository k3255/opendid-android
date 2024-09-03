/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.sdk.core.keymanager.datamodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.omnione.did.sdk.datamodel.common.enums.AlgorithmType;

public class SecureKeyGenRequest extends KeyGenRequest {
    @SerializedName("accessMethod")
    @Expose
    private KeyStoreAccessMethod.KEYSTORE_ACCESS_METHOD accessMethod;

    public SecureKeyGenRequest() {}

    public SecureKeyGenRequest(String id, AlgorithmType.ALGORITHM_TYPE algoType, StorageOption.STORAGE_OPTION storageOption, KeyStoreAccessMethod.KEYSTORE_ACCESS_METHOD accessMethod) {
        super(id, algoType, storageOption);
        this.accessMethod = accessMethod;
    }

    public KeyStoreAccessMethod.KEYSTORE_ACCESS_METHOD getAccessMethod() {
        return accessMethod;
    }

    public void setAccessMethod(KeyStoreAccessMethod.KEYSTORE_ACCESS_METHOD accessMethod) {
        this.accessMethod = accessMethod;
    }
}
