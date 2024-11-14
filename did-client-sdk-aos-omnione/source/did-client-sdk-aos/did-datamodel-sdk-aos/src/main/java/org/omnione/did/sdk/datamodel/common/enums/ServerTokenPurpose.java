/*
 * Copyright 2024 OmniOne.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.omnione.did.sdk.datamodel.common.enums;

import org.omnione.did.sdk.datamodel.util.IntEnum;

public class ServerTokenPurpose {

    public enum SERVER_TOKEN_PURPOSE implements IntEnum {
        CREATE_DID(5),
        UPDATE_DID(6),
        RESTORE_DID(7),
        ISSUE_VC(8),
        REVOKE_VC(9),
        PRESENT_VP(10),
        CREATE_DID_AND_ISSUE_VC(13);

        final private int value;
        SERVER_TOKEN_PURPOSE(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public static SERVER_TOKEN_PURPOSE fromValue(int value) {
            for (SERVER_TOKEN_PURPOSE type : values()) {
                if (type.getValue() == value) {
                    return type;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            switch (this) {
                case CREATE_DID:
                    return "CreateDID";
                case UPDATE_DID:
                    return "UpdateDID";
                case RESTORE_DID:
                    return "RestoreDID";
                case ISSUE_VC:
                    return "IssueVc";
                case REVOKE_VC:
                    return "RevokeVc";
                case PRESENT_VP:
                    return "PresentVp";
                case CREATE_DID_AND_ISSUE_VC:
                    return "CreateDIDAndIssueVc";
                default:
                    return "Unknown";
            }
        }
    }
}
