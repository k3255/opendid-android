/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.sdk.utility.DataModels;

public class MultibaseType {
    public enum MULTIBASE_TYPE {
        BASE_16("f"),
        BASE_16_UPPER("F"),
        BASE_58_BTC("z"),
        BASE_64("m"),
        BASE_64_URL("u");

        private String value;

        MULTIBASE_TYPE(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public static MULTIBASE_TYPE fromValue(String value) {
            for (MULTIBASE_TYPE type : values()) {
                if (type.getValue().equals(value)) {
                    return type;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            switch (this) {
                case BASE_16:
                    return "f";
                case BASE_16_UPPER:
                    return "F";
                case BASE_58_BTC:
                    return "z";
                case BASE_64:
                    return "m";
                case BASE_64_URL:
                    return "u";
                default:
                    return "Unknown";
            }
        }
    }

}
