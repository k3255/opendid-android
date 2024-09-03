/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.sdk.datamodel.common.enums;

import org.omnione.did.sdk.datamodel.util.StringEnum;

public class CredentialSchemaType {
    public enum CREDENTIAL_SCHEMA_TYPE implements StringEnum {
        osdSchemaCredential("OsdSchemaCredential");

        final private String value;
        CREDENTIAL_SCHEMA_TYPE(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }

        public static CREDENTIAL_SCHEMA_TYPE fromValue(String value) {
            for (CREDENTIAL_SCHEMA_TYPE type : values()) {
                if (type.getValue().equals(value)) {
                    return type;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            switch (this) {
                case osdSchemaCredential:
                    return "OsdSchemaCredential";
                default:
                    return "Unknown";
            }
        }
    }
}
