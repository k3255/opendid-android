/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.sdk.datamodel.common.enums;

import org.omnione.did.sdk.datamodel.util.StringEnum;

public class SymmetricPaddingType {
    public enum SYMMETRIC_PADDING_TYPE implements StringEnum {
        NOPAD("NOPAD"),
        PKCS5("PKCS5");
        final private String value;
        SYMMETRIC_PADDING_TYPE(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }

        public static SYMMETRIC_PADDING_TYPE fromValue(String value) {
            for (SYMMETRIC_PADDING_TYPE type : values()) {
                if (type.getValue().equals(value)) {
                    return type;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            switch (this) {
                case NOPAD:
                    return "NOPAD";
                case PKCS5:
                    return "PKCS5";
                default:
                    return "Unknown";
            }
        }
    }
}
