/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.sdk.utility.DataModels;

public class DigestEnum {
    public enum DIGEST_ENUM {
        SHA_256("SHA256"),
        SHA_384("SHA384"),
        SHA_512("SHA512");

        private String value;

        DIGEST_ENUM(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public static DIGEST_ENUM fromValue(String value) {
            for (DIGEST_ENUM type : values()) {
                if (type.getValue().equals(value)) {
                    return type;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            switch (this) {
                case SHA_256:
                    return "SHA256";
                case SHA_384:
                    return "SHA384";
                case SHA_512:
                    return "SHA512";
                default:
                    return "Unknown";
            }
        }
    }

}
