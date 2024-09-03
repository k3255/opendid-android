/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.sdk.datamodel.common.enums;

import org.omnione.did.sdk.datamodel.util.StringEnum;

public class EllipticCurveType {
    public enum ELLIPTIC_CURVE_TYPE implements StringEnum {
        SECP256K1("Secp256k1"),
        SECP256R1("Secp256r1");

        final private String value;
        ELLIPTIC_CURVE_TYPE(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }

        public static ELLIPTIC_CURVE_TYPE fromValue(String value) {
            for (ELLIPTIC_CURVE_TYPE type : values()) {
                if (type.getValue().equals(value)) {
                    return type;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            switch (this) {
                case SECP256K1:
                    return "Secp256k1";
                case SECP256R1:
                    return "Secp256r1";
                default:
                    return "Unknown";
            }
        }

        public static ELLIPTIC_CURVE_TYPE convertFrom(AlgorithmType.ALGORITHM_TYPE type){
            switch (type) {
                case SECP256K1:
                    return ELLIPTIC_CURVE_TYPE.SECP256K1;
                case SECP256R1:
                    return ELLIPTIC_CURVE_TYPE.SECP256R1;
                default:
                    throw new RuntimeException();
            }
        }
        public static AlgorithmType.ALGORITHM_TYPE convertTo(ELLIPTIC_CURVE_TYPE type){
            switch (type) {
                case SECP256K1:
                    return AlgorithmType.ALGORITHM_TYPE.SECP256K1;
                case SECP256R1:
                    return AlgorithmType.ALGORITHM_TYPE.SECP256R1;
                default:
                    throw new RuntimeException();
            }
        }
    }
}
