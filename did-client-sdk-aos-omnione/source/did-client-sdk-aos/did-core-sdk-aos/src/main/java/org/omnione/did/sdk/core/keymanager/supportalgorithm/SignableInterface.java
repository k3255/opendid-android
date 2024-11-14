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

package org.omnione.did.sdk.core.keymanager.supportalgorithm;

import org.omnione.did.sdk.core.exception.WalletCoreException;
import org.omnione.did.sdk.core.keymanager.datamodel.KeyGenerationInfo;

public interface SignableInterface {
    KeyGenerationInfo generateKey();
    byte[] sign(byte[] privateKey, byte[] digest) throws WalletCoreException;
    boolean verify(byte[] publicKey, byte[] digest, byte[] signature) throws WalletCoreException;
}
