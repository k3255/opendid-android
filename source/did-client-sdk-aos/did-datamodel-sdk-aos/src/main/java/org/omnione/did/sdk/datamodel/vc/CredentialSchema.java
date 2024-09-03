/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.sdk.datamodel.vc;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.omnione.did.sdk.datamodel.common.enums.CredentialSchemaType;

public class CredentialSchema {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("type")
    @Expose
    private CredentialSchemaType.CREDENTIAL_SCHEMA_TYPE type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CredentialSchemaType.CREDENTIAL_SCHEMA_TYPE getType() {
        return type;
    }

    public void setType(CredentialSchemaType.CREDENTIAL_SCHEMA_TYPE type) {
        this.type = type;
    }

    public void fromJson(String val) {
        Gson gson = new Gson();
        CredentialSchema obj = gson.fromJson(val, CredentialSchema.class);

        this.id = obj.getId();
        this.type = obj.getType();
    }
}
