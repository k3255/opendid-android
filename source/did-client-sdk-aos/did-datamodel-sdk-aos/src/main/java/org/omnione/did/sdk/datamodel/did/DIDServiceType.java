/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.sdk.datamodel.did;

import org.omnione.did.sdk.datamodel.util.StringEnum;

public class DIDServiceType {
    public enum DID_SERVICE_TYPE implements StringEnum {
        linkedDomains("LinkedDomains"),
        credentialRegistry("CredentialRegistry");

        final private String value;
        DID_SERVICE_TYPE(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }

        public static DID_SERVICE_TYPE fromValue(String value) {
            for (DID_SERVICE_TYPE type : values()) {
                if (type.getValue().equals(value)) {
                    return type;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            switch (this) {
                case linkedDomains:
                    return "LinkedDomains";
                case credentialRegistry:
                    return "CredentialRegistry";
                default:
                    return "Unknown";
            }
        }
    }
}
