/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.sdk.datamodel.common.enums;

public class Location {
    public enum LOCATION {
        inline("inline"),
        remote("remote"),
        attach("attach");

        final private String value;
        LOCATION(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }

        public static LOCATION fromValue(String value) {
            for (LOCATION type : values()) {
                if (type.getValue().equals(value)) {
                    return type;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            switch (this) {
                case inline:
                    return "inline";
                case remote:
                    return "remote";
                case attach:
                    return "attach";
                default:
                    return "Unknown";
            }
        }
    }
}
