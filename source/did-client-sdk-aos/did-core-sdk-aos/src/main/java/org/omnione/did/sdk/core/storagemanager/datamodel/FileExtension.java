/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.sdk.core.storagemanager.datamodel;

public class FileExtension {
    public enum FILE_EXTENSION {
        KEY("key"),
        DID("did"),
        VC("vc");

        private String value;

        FILE_EXTENSION(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public static FILE_EXTENSION fromValue(String value) {
            for (FILE_EXTENSION type : values()) {
                if (type.getValue().equals(value)) {
                    return type;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            switch (this) {
                case KEY:
                    return "key";
                case DID:
                    return "did";
                case VC:
                    return "vc";
                default:
                    return "Unknown";
            }
        }
    }

}
