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

package org.omnione.did.sdk.core.keymanager.datamodel;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.omnione.did.sdk.datamodel.common.BaseObject;

public class DetailKeyInfo extends BaseObject {
    @SerializedName("id")
    @Expose
    private String id; // keyId

    @SerializedName("privateKey")
    @Expose
    private String privateKey;

    @SerializedName("salt")
    @Expose
    private String salt;
    public DetailKeyInfo(){}
    public DetailKeyInfo(String id) {
        this.id = id;
    }
    public DetailKeyInfo(String id, String privateKey) {
        this.id = id;
        this.privateKey = privateKey;
    }
    public DetailKeyInfo(String id, String privateKey, String salt) {
        this.id = id;
        this.privateKey = privateKey;
        this.salt = salt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public void fromJson(String val) {
        Gson gson = new Gson();
        DetailKeyInfo obj = gson.fromJson(val, DetailKeyInfo.class);

        id = obj.getId();
        salt = obj.getSalt();
        privateKey = obj.getPrivateKey();

    }
}
