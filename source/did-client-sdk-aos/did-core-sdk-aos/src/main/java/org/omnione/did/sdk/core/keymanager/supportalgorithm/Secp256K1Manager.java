/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.sdk.core.keymanager.supportalgorithm;

import org.omnione.did.sdk.core.exception.WalletCoreException;
import org.omnione.did.sdk.core.keymanager.datamodel.KeyGenerationInfo;

public class Secp256K1Manager implements SignableInterface {

    @Override
    public KeyGenerationInfo generateKey() {
        return null;
    }

    @Override
    public byte[] sign(byte[] privateKey, byte[] digest) throws WalletCoreException {
        return new byte[0];
    }

    @Override
    public boolean verify(byte[] publicKey, byte[] digest, byte[] signature) throws WalletCoreException {
        return false;
    }
}
