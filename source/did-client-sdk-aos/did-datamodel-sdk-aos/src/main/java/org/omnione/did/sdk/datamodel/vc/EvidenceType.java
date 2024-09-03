/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.sdk.datamodel.vc;

import org.omnione.did.sdk.datamodel.util.StringEnum;

public class EvidenceType {
    public enum EVIDENCE_TYPE implements StringEnum {
        documentVerification("DocumentVerification");

        final private String value;
        EVIDENCE_TYPE(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }

        public static EVIDENCE_TYPE fromValue(String value) {
            for (EVIDENCE_TYPE type : values()) {
                if (type.getValue().equals(value)) {
                    return type;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            switch (this) {
                case documentVerification:
                    return "DocumentVerificationEvidence";
                default:
                    return "Unknown";
            }
        }
    }

}
