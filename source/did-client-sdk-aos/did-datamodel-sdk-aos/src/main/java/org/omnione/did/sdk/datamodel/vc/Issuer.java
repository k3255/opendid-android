/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.sdk.datamodel.vc;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Issuer {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("name")
    @Expose
    private String name; //option

    @SerializedName("certVcRef")
    @Expose
    private String certVcRef; //option

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCertVcRef() {
        return certVcRef;
    }

    public void setCertVcRef(String certVcRef) {
        this.certVcRef = certVcRef;
    }

    public void fromJson(String val) {
        Gson gson = new Gson();
        Issuer obj = gson.fromJson(val, Issuer.class);

        this.id = obj.getId();
        this.name = obj.getName();
        this.certVcRef = obj.getCertVcRef();
    }
}
