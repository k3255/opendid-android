/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.sdk.datamodel.common.enums;

import org.omnione.did.sdk.datamodel.util.StringEnum;

public class ClaimFormat {
    public enum CLAIM_FORMAT implements StringEnum {
        plain("plain"),
        html("html"),
        xml("xml"),
        csv("csv"),
        png("png"),
        jpg("jpg"),
        gif("gif"),
        txt("txt"),
        pdf("pdf"),
        word("word");

        final private String value;
        CLAIM_FORMAT(String value) {
            this.value = value;
        }
        public String getValue() {
            return value;
        }

        public static CLAIM_FORMAT fromValue(String value) {
            for (CLAIM_FORMAT type : values()) {
                if (type.getValue().equals(value)) {
                    return type;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            switch (this) {
                case plain:
                    return "plain";
                case html:
                    return "html";
                case xml:
                    return "xml";
                case csv:
                    return "csv";
                case png:
                    return "png";
                case jpg:
                    return "jpg";
                case gif:
                    return "gif";
                case txt:
                    return "txt";
                case pdf:
                    return "pdf";
                case word:
                    return "word";
                default:
                    return "Unknown";
            }
        }
    }
}
