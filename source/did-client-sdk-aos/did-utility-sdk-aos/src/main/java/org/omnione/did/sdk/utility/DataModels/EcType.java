/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.sdk.utility.DataModels;

public class EcType {
    public enum EC_TYPE {
        SECP256_K1("Secp256k1"),
        SECP256_R1("Secp256r1");

        private String value;
        EC_TYPE(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }

        public static EC_TYPE fromValue(String value) {
            for (EC_TYPE type : values()) {
                if (type.getValue().equals(value)) {
                    return type;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            switch (this) {
                case SECP256_K1:	    return "Secp256k1";
                case SECP256_R1:	    return "Secp256r1";
                default:      		return "Unknown";
            }
        }
    }

}
