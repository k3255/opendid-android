/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.sdk.core.exception;

public class WalletCoreException extends Exception {
    protected int errorCode;
    protected String errMsg;
    protected String errorReason;

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public String getErrorReason() {
        return errorReason;
    }

    public WalletCoreException(WalletCoreErrorCode WalletCoreErrorCode){
        super("[" + WalletCoreErrorCode.getWalletCoreCode() + WalletCoreErrorCode.getFeature() + String.format("%03d", WalletCoreErrorCode.getCode()) +"] " + WalletCoreErrorCode.getMsg());
        this.errorCode = WalletCoreErrorCode.getCode();
        this.errMsg = WalletCoreErrorCode.getMsg();
    }
    public WalletCoreException(WalletCoreErrorCode WalletCoreErrorCode, String paramName){
        super("["+ WalletCoreErrorCode.getWalletCoreCode() + WalletCoreErrorCode.getFeature() + String.format("%03d", WalletCoreErrorCode.getCode()) +"] " + WalletCoreErrorCode.getMsg() + paramName);
        this.errorCode = WalletCoreErrorCode.getCode();
        this.errMsg = WalletCoreErrorCode.getMsg() + paramName;
    }
    public WalletCoreException(WalletCoreErrorCode WalletCoreErrorCode, Throwable throwable){
        super("[" + WalletCoreErrorCode.getWalletCoreCode() + WalletCoreErrorCode.getFeature() + String.format("%03d", WalletCoreErrorCode.getCode()) +"] , [Message] " + throwable.getMessage());
        this.errorCode = WalletCoreErrorCode.getCode();
        this.errMsg = throwable.getMessage();
    }
    public WalletCoreException(int code){
        super("[ErrorCode " + WalletCoreErrorCode.getEnumByCode(code).getCode() + "] , [Message] " + WalletCoreErrorCode.getEnumByCode(code).getMsg());
        this.errorCode = WalletCoreErrorCode.getEnumByCode(code).getCode();
        this.errorReason = WalletCoreErrorCode.getEnumByCode(code).getMsg();
    }
    public WalletCoreException(int code, Throwable throwable){
        super("[ErrorCode " + WalletCoreErrorCode.getEnumByCode(code).getCode() + "] , [Message] " + WalletCoreErrorCode.getEnumByCode(code).getMsg(), throwable);
        this.errorCode = WalletCoreErrorCode.getEnumByCode(code).getCode();
        this.errorReason = WalletCoreErrorCode.getEnumByCode(code).getMsg();
    }
}
