/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.sdk.core.vcmanager.datamodel;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.omnione.did.sdk.datamodel.common.BaseObject;

import java.util.List;

public class ClaimInfo extends BaseObject {
    @SerializedName("credentialId")
    @Expose
    private String credentialId;

    @SerializedName("claimCodes")
    @Expose
    private List<String> claimCodes;

    public ClaimInfo(){}

    public ClaimInfo(String credentialId, List<String> claimCodes) {
        this.credentialId = credentialId;
        this.claimCodes = claimCodes;
    }

    public String getCredentialId() {
        return credentialId;
    }

    public void setCredentialId(String credentialId) {
        this.credentialId = credentialId;
    }

    public List<String> getClaimCodes() {
        return claimCodes;
    }

    public void setClaimCodes(List<String> claimCodes) {
        this.claimCodes = claimCodes;
    }

    @Override
    public void fromJson(String val) {
        Gson gson = new Gson();
        ClaimInfo obj = gson.fromJson(val, ClaimInfo.class);

        credentialId = obj.getCredentialId();
        claimCodes = obj.getClaimCodes();

    }
}
