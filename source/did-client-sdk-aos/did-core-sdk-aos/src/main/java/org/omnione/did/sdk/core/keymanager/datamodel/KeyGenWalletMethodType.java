/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.sdk.core.keymanager.datamodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KeyGenWalletMethodType {
    @SerializedName("walletMethodType")
    @Expose
    private WALLET_METHOD_TYPE walletMethodType;
    @SerializedName("pin")
    @Expose
    private String pin;
    // 생성자
    public KeyGenWalletMethodType() {
        walletMethodType = WALLET_METHOD_TYPE.NONE;
    }

    public KeyGenWalletMethodType(String pin) {
        walletMethodType = WALLET_METHOD_TYPE.PIN;
        this.pin = pin;
    }


    public static KeyGenWalletMethodType pin(String pin) {
        KeyGenWalletMethodType walletMethodType = new KeyGenWalletMethodType();
        walletMethodType.pin = pin;
        return walletMethodType;
    }

    public String getPin() {
        return pin;
    }

    public WALLET_METHOD_TYPE getWalletMethodType() {
        return walletMethodType;
    }

    public void setWalletMethodType(WALLET_METHOD_TYPE walletMethodType) {
        this.walletMethodType = walletMethodType;
    }

    public enum WALLET_METHOD_TYPE {

        NONE("NONE"),
        PIN("PIN");

        final private String value;
        WALLET_METHOD_TYPE(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }

        public static WALLET_METHOD_TYPE fromValue(String value) {
            for (WALLET_METHOD_TYPE type : values()) {
                if (type.getValue().equals(value)) {
                    return type;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            switch (this) {
                case NONE:
                    return "NONE";
                case PIN:
                    return "PIN";
                default:
                    return "Unknown";
            }
        }
    }
}
