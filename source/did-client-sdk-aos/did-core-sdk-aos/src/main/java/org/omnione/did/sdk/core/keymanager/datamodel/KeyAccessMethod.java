/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.sdk.core.keymanager.datamodel;

import org.omnione.did.sdk.datamodel.util.IntEnum;

public class KeyAccessMethod {
    public enum KEY_ACCESS_METHOD implements IntEnum {
        WALLET_NONE(0),
        WALLET_PIN(1),
        KEYSTORE_NONE(8),
        KEYSTORE_BIOMETRY(9);

        private int value;

        KEY_ACCESS_METHOD(int value){
            this.value = value;
        }

        public int getValue(){
            return value;
        }

        public static KEY_ACCESS_METHOD fromValue(int value){
            for(KEY_ACCESS_METHOD option : values()){
                if(option.getValue() == value){
                    return option;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            switch (this) {
                case WALLET_NONE:   		return "WALLET_NONE";
                case WALLET_PIN:   	        return "WALLET_PIN";
                case KEYSTORE_NONE:   		return "KEYSTORE_NONE";
                case KEYSTORE_BIOMETRY:     return "KEYSTORE_BIOMETRY";
                default:      		return "Unknown";
            }
        }
    }



}
