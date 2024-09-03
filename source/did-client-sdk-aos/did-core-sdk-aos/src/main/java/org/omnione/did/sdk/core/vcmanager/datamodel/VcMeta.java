/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.sdk.core.vcmanager.datamodel;

import org.omnione.did.sdk.core.storagemanager.datamodel.Meta;

public class VcMeta extends Meta {
    String issuerId;
    String credentialSchemaType;
    String credentialSchemaId;
    String issuanceDate;
    String validFrom;
    String validUntil;

    public String getIssuerId() {
        return issuerId;
    }

    public void setIssuerId(String issuerId) {
        this.issuerId = issuerId;
    }

    public String getCredentialSchemaType() {
        return credentialSchemaType;
    }

    public void setCredentialSchemaType(String credentialSchemaType) {
        this.credentialSchemaType = credentialSchemaType;
    }

    public String getCredentialSchemaId() {
        return credentialSchemaId;
    }

    public void setCredentialSchemaId(String credentialSchemaId) {
        this.credentialSchemaId = credentialSchemaId;
    }
}
