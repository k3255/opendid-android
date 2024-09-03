/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.sdk.core.common;

import android.content.Context;

import org.omnione.did.sdk.core.exception.WalletCoreErrorCode;
import org.omnione.did.sdk.core.exception.WalletCoreException;

public class SecureEncryptor {
    private static final String SECURE_ENCRPTOR_ALIAS_PREFIX = "opendid_wallet_encryption_";
    private static final String SECURE_ENCRPTOR_ALIAS = "secureEncryptor";

    public static byte[] encrypt(byte[] plainData, Context context) throws WalletCoreException {
       if (plainData == null || plainData.length == 0){
           throw new WalletCoreException(WalletCoreErrorCode.ERR_CODE_SECURE_ENCRYPTOR_INVALID_PARAMETER, "plainData");
       }
       if (context == null){
           throw new WalletCoreException(WalletCoreErrorCode.ERR_CODE_SECURE_ENCRYPTOR_INVALID_PARAMETER, "context");
       }
       byte[] cipher = KeystoreManager.encrypt(SECURE_ENCRPTOR_ALIAS_PREFIX + SECURE_ENCRPTOR_ALIAS, plainData, context);
       return cipher;
    }


    public static byte[] decrypt(byte[] cipherData) throws WalletCoreException {
        if (cipherData == null || cipherData.length == 0){
            throw new WalletCoreException(WalletCoreErrorCode.ERR_CODE_SECURE_ENCRYPTOR_INVALID_PARAMETER, "cipherData");
        }
        byte[] plain = KeystoreManager.decrypt(SECURE_ENCRPTOR_ALIAS_PREFIX + SECURE_ENCRPTOR_ALIAS, cipherData);
        return plain;
    }

}
