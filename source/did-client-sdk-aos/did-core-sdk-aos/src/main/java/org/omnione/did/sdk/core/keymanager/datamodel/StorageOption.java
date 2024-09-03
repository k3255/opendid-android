/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.sdk.core.keymanager.datamodel;

import org.omnione.did.sdk.datamodel.util.IntEnum;

public class StorageOption {
    public enum STORAGE_OPTION implements IntEnum {
        WALLET(0),
        KEYSTORE(1);

        private int value;

        STORAGE_OPTION(int value){
            this.value = value;
        }

        public int getValue(){
            return value;
        }

        public static STORAGE_OPTION fromValue(int value){
            for(STORAGE_OPTION option : values()){
                if(option.getValue() == value){
                    return option;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            switch (this) {
                case WALLET:   		return "WALLET";
                case KEYSTORE:   	    return "KEYSTORE";
                default:      		return "Unknown";
            }
        }
    }



}
