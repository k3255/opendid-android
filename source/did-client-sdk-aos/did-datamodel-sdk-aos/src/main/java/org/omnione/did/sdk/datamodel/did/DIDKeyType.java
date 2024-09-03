/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.sdk.datamodel.did;

import org.omnione.did.sdk.datamodel.common.enums.AlgorithmType;
import org.omnione.did.sdk.datamodel.util.StringEnum;

public class DIDKeyType {
    public enum DID_KEY_TYPE implements StringEnum {
        rsaVerificationKey2018("RsaVerificationKey2018"),
        secp256k1VerificationKey2018("Secp256k1VerificationKey2018"),
        secp256r1VerificationKey2018("Secp256r1VerificationKey2018");

        final private String value;
        DID_KEY_TYPE(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }

        public static DID_KEY_TYPE fromValue(String value) {
            for (DID_KEY_TYPE type : values()) {
                if (type.getValue().equals(value)) {
                    return type;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            switch (this) {
                case rsaVerificationKey2018:
                    return "RsaVerificationKey2018";
                case secp256k1VerificationKey2018:
                    return "Secp256k1VerificationKey2018";
                case secp256r1VerificationKey2018:
                    return "Secp256r1VerificationKey2018";
                default:
                    return "Unknown";
            }
        }

        public static DID_KEY_TYPE convertFrom(AlgorithmType.ALGORITHM_TYPE type){
            switch (type) {
                case RSA:
                    return DID_KEY_TYPE.rsaVerificationKey2018;
                case SECP256K1:
                    return DID_KEY_TYPE.secp256k1VerificationKey2018;
                case SECP256R1:
                    return DID_KEY_TYPE.secp256r1VerificationKey2018;
                default:
                    throw new RuntimeException();
            }
        }
        public static AlgorithmType.ALGORITHM_TYPE convertTo(DID_KEY_TYPE type){
            switch (type) {
                case rsaVerificationKey2018:
                    return AlgorithmType.ALGORITHM_TYPE.RSA;
                case secp256k1VerificationKey2018:
                    return AlgorithmType.ALGORITHM_TYPE.SECP256K1;
                case secp256r1VerificationKey2018:
                    return AlgorithmType.ALGORITHM_TYPE.SECP256R1;
                default:
                    throw new RuntimeException();
            }
        }
    }
}
