/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.sdk.core.didmanager.datamodel;

import org.omnione.did.sdk.datamodel.util.IntEnum;

public class DIDMethodType {
    public enum DID_METHOD_TYPE implements IntEnum {
        assertionMethod(1),
        authentication(1<<1),
        keyAgreement(1<<2),
        capabilityInvocation(1<<3),
        capabilityDelegation(1<<4);

        final private int value;
        DID_METHOD_TYPE(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }

        public static DID_METHOD_TYPE fromValue(int value) {
            for (DID_METHOD_TYPE type : values()) {
                if (type.getValue()== value) {
                    return type;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            switch (this) {
                case assertionMethod:
                    return "assertionMethod";
                case authentication:
                    return "authentication";
                case keyAgreement:
                    return "keyAgreement";
                case capabilityInvocation:
                    return "capabilityInvocation";
                case capabilityDelegation:
                    return "capabilityDelegation";
                default:
                    return "Unknown";
            }
        }

    }
}
