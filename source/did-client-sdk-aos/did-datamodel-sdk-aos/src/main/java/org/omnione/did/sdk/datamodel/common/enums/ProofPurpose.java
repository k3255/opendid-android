/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.sdk.datamodel.common.enums;

import org.omnione.did.sdk.datamodel.util.StringEnum;

public class ProofPurpose {
    public enum PROOF_PURPOSE implements StringEnum {
        assertionMethod("assertionMethod"),
        authentication("authentication"),
        keyAgreement("keyAgreement"),
        capabilityInvocation("capabilityInvocation"),
        capabilityDelegation("capabilityDelegation");

        final private String value;
        PROOF_PURPOSE(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }

        public static PROOF_PURPOSE fromValue(String value) {
            for (PROOF_PURPOSE type : values()) {
                if (type.getValue().equals(value)) {
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
