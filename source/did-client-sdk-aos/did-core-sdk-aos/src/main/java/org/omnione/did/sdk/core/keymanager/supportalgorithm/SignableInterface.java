/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.sdk.core.keymanager.supportalgorithm;

import org.omnione.did.sdk.core.exception.WalletCoreException;
import org.omnione.did.sdk.core.keymanager.datamodel.KeyGenerationInfo;

public interface SignableInterface {
    KeyGenerationInfo generateKey();
    byte[] sign(byte[] privateKey, byte[] digest) throws WalletCoreException;
    boolean verify(byte[] publicKey, byte[] digest, byte[] signature) throws WalletCoreException;
}
