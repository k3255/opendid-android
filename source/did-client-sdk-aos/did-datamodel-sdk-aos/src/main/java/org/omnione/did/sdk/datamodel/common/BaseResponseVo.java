/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.sdk.datamodel.common;

public abstract class BaseResponseVo {
    private String txId;
    private Integer code;
    private String message;

    public String getTxId() {
        return txId;
    }

    public void setTxId(String txId) {
        this.txId = txId;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
