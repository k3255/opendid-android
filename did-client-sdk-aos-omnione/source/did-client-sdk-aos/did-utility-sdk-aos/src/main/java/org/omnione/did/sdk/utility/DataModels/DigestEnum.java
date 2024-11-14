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

package org.omnione.did.sdk.utility.DataModels;

public class DigestEnum {
    public enum DIGEST_ENUM {
        SHA_256("SHA256"),
        SHA_384("SHA384"),
        SHA_512("SHA512");

        private String value;

        DIGEST_ENUM(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public static DIGEST_ENUM fromValue(String value) {
            for (DIGEST_ENUM type : values()) {
                if (type.getValue().equals(value)) {
                    return type;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            switch (this) {
                case SHA_256:
                    return "SHA256";
                case SHA_384:
                    return "SHA384";
                case SHA_512:
                    return "SHA512";
                default:
                    return "Unknown";
            }
        }
    }

}
