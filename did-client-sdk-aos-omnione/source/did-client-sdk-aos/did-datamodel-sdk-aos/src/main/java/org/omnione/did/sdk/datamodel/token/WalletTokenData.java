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

package org.omnione.did.sdk.datamodel.token;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.omnione.did.sdk.datamodel.common.Proof;
import org.omnione.did.sdk.datamodel.util.IntEnumAdapterFactory;
import org.omnione.did.sdk.datamodel.util.JsonSortUtil;
import org.omnione.did.sdk.datamodel.util.StringEnumAdapterFactory;

public class WalletTokenData {
    WalletTokenSeed seed;
    String sha256_pii;
    Provider provider;
    String nonce;
    Proof proof;

    public WalletTokenSeed getSeed() {
        return seed;
    }

    public void setSeed(WalletTokenSeed seed) {
        this.seed = seed;
    }

    public String getSha256_pii() {
        return sha256_pii;
    }

    public void setSha256_pii(String sha256_pii) {
        this.sha256_pii = sha256_pii;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public Proof getProof() {
        return proof;
    }

    public void setProof(Proof proof) {
        this.proof = proof;
    }

    public String toJson() {
               Gson gson = new GsonBuilder()
                .registerTypeAdapterFactory(new IntEnumAdapterFactory())
                .registerTypeAdapterFactory(new StringEnumAdapterFactory())
                       .disableHtmlEscaping()
                .create();

        String json = gson.toJson(this);
        return JsonSortUtil.sortJsonString(gson, json);

    }
}
