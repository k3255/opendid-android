/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.sdk.datamodel.common.enums;

import org.omnione.did.sdk.datamodel.util.StringEnum;

public class SymmetricCipherType {
    public enum SYMMETRIC_CIPHER_TYPE implements StringEnum {
        AES128CBC("AES-128-CBC"),
        AES128ECB("AES-128-ECB"),
        AES256CBC("AES-256-CBC"),
        AES256ECB("AES-256-ECB");
        final private String value;
        SYMMETRIC_CIPHER_TYPE(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }

        public static SYMMETRIC_CIPHER_TYPE fromValue(String value) {
            for (SYMMETRIC_CIPHER_TYPE type : values()) {
                if (type.getValue().equals(value)) {
                    return type;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            switch (this) {
                case AES128CBC:
                    return "AES-128-CBC";
                case AES128ECB:
                    return "AES-128-ECB";
                case AES256CBC:
                    return "AES-256-CBC";
                case AES256ECB:
                    return "AES-256-ECB";
                default:
                    return "Unknown";
            }
        }
    }
}
