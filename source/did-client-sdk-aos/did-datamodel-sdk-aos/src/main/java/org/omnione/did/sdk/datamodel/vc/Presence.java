/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.sdk.datamodel.vc;

import org.omnione.did.sdk.datamodel.util.StringEnum;

public class Presence {
    public enum PRESENCE implements StringEnum {
        physical("Physical"),
        digital("Digital");

        final private String value;
        PRESENCE(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }

        public static PRESENCE fromValue(String value) {
            for (PRESENCE type : values()) {
                if (type.getValue().equals(value)) {
                    return type;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            switch (this) {
                case physical:
                    return "Physical";
                case digital:
                    return "Digital";
                default:
                    return "Unknown";
            }
        }
    }
}
