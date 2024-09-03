/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.sdk.datamodel.common.enums;

import org.omnione.did.sdk.datamodel.util.IntEnum;

public class VerifyAuthType {
    public enum VERIFY_AUTH_TYPE implements IntEnum {
        ANY(0x00000000),
        FREE(0x00000001),
        PIN(0x00000002),
        BIO(0x00000004),
        PIN_OR_BIO(0x00000006),
        PIN_AND_BIO(0x00008006);

        final private int value;
        VERIFY_AUTH_TYPE(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }

        public static VERIFY_AUTH_TYPE fromValue(int value) {
            for (VERIFY_AUTH_TYPE type : values()) {
                if (type.getValue()== value) {
                    return type;
                }
            }
            return null;
        }

    }
}
