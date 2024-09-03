/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.sdk.utility.Errors;

public class UtilityException extends Exception {
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

    public UtilityException(UtilityErrorCode UtilityErrorCode){
        super("[" + UtilityErrorCode.getUtilityCode() + UtilityErrorCode.getFeature() + String.format("%03d", UtilityErrorCode.getCode()) +"] " + UtilityErrorCode.getMsg());
        this.errorCode = UtilityErrorCode.getCode();
        this.errMsg = UtilityErrorCode.getMsg();
    }
    public UtilityException(UtilityErrorCode UtilityErrorCode, String paramName){
        super("[" + UtilityErrorCode.getUtilityCode() + UtilityErrorCode.getFeature() + String.format("%03d", UtilityErrorCode.getCode()) +"] " + UtilityErrorCode.getMsg() + paramName);
        this.errorCode = UtilityErrorCode.getCode();
        this.errMsg = UtilityErrorCode.getMsg() + paramName;
    }
    public UtilityException(UtilityErrorCode UtilityErrorCode, Throwable throwable){
        super("[" + UtilityErrorCode.getUtilityCode() + UtilityErrorCode.getFeature() + String.format("%03d", UtilityErrorCode.getCode()) +"] , [Message] " + throwable.getMessage());
        this.errorCode = UtilityErrorCode.getCode();
        this.errMsg = throwable.getMessage();
    }
    public UtilityException(int code){
        super("[ErrorCode " + UtilityErrorCode.getEnumByCode(code).getCode() + "] , [Message] " + UtilityErrorCode.getEnumByCode(code).getMsg());
        this.errorCode = UtilityErrorCode.getEnumByCode(code).getCode();
        this.errorReason = UtilityErrorCode.getEnumByCode(code).getMsg();
    }
    public UtilityException(int code, Throwable throwable){
        super("[ErrorCode " + UtilityErrorCode.getEnumByCode(code).getCode() + "] , [Message] " + UtilityErrorCode.getEnumByCode(code).getMsg(), throwable);
        this.errorCode = UtilityErrorCode.getEnumByCode(code).getCode();
        this.errorReason = UtilityErrorCode.getEnumByCode(code).getMsg();
    }
}
