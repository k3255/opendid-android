/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.sdk.datamodel.common;

public abstract class BaseRequestVo extends SortData {
    private String id;
    private String txId;
    public BaseRequestVo(String id){
        this.id = id;
    }
    public BaseRequestVo(String id, String txId){
        this.id = id;
        this.txId = txId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTxId() {
        return txId;
    }

    public void setTxId(String txId) {
        this.txId = txId;
    }
}
