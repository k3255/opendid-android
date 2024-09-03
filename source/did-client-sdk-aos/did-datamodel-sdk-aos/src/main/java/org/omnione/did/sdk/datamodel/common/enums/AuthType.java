/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.sdk.datamodel.common.enums;

import org.omnione.did.sdk.datamodel.util.IntEnum;

public class AuthType {
    public enum AUTH_TYPE implements IntEnum {
        FREE(1),
        PIN(2),
        BIO(4);

        final private int value;
        AUTH_TYPE(int value) {
            this.value = value;
        }
        public int getValue() {
            return value;
        }

        public static AUTH_TYPE fromValue(int value) {
            for (AUTH_TYPE type : values()) {
                if (type.getValue() == value) {
                    return type;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            switch (this) {
                case FREE:
                    return "무인증";
                case PIN:
                    return "비밀번호 인증";
                case BIO:
                    return "생체인증";
                default:
                    return "Unknown";
            }
        }
    }
}
