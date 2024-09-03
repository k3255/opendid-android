/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.sdk.datamodel.vc;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CredentialSubject {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("claims")
    @Expose
    private List<Claim> claims;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Claim> getClaims() {
        return claims;
    }

    public void setClaims(List<Claim> claims) {
        this.claims = claims;
    }

    public void fromJson(String val) {
        Gson gson = new Gson();
        CredentialSubject obj = gson.fromJson(val, CredentialSubject.class);

        this.id = obj.getId();
        this.claims = obj.getClaims();
    }
}
