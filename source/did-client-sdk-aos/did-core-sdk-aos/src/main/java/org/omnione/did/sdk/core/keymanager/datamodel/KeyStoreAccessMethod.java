/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.sdk.core.keymanager.datamodel;

import org.omnione.did.sdk.datamodel.util.IntEnum;

public class KeyStoreAccessMethod {

    public enum KEYSTORE_ACCESS_METHOD implements IntEnum {
        NONE(0),
        BIOMETRY(1);

        final private int value;
        KEYSTORE_ACCESS_METHOD(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }

        public static KEYSTORE_ACCESS_METHOD fromValue(int value) {
            for (KEYSTORE_ACCESS_METHOD type : values()) {
                if (type.getValue() == value) {
                    return type;
                }
            }
            return null;
        }

    }
}
