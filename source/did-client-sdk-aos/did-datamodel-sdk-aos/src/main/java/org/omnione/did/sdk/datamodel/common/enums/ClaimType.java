/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.sdk.datamodel.common.enums;

import org.omnione.did.sdk.datamodel.util.StringEnum;

public class ClaimType {
    public enum CLAIM_TYPE implements StringEnum {
        text("text"),
        image("image"),
        document("document");

        final private String value;
        CLAIM_TYPE(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }

        public static CLAIM_TYPE fromValue(String value) {
            for (CLAIM_TYPE type : values()) {
                if (type.getValue().equals(value)) {
                    return type;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            switch (this) {
                case text:
                    return "text";
                case image:
                    return "image";
                case document:
                    return "document";
                default:
                    return "Unknown";
            }
        }
    }
}
