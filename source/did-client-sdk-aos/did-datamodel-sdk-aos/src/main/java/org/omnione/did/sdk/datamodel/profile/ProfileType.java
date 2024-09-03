/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.sdk.datamodel.profile;

import org.omnione.did.sdk.datamodel.util.StringEnum;

public class ProfileType {
    public enum PROFILE_TYPE implements StringEnum {
        issueProfile("IssueProfile"),
        verifyProfile("VerifyProfile");

        final private String value;
        PROFILE_TYPE(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }

        public static PROFILE_TYPE fromValue(String value) {
            for (PROFILE_TYPE type : values()) {
                if (type.getValue().equals(value)) {
                    return type;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            switch (this) {
                case issueProfile:
                    return "IssueProfile";
                case verifyProfile:
                    return "VerifyProfile";
                default:
                    return "Unknown";
            }
        }
    }
}
