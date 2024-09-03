/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.sdk.datamodel.did;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Service {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("type")
    @Expose
    private DIDServiceType.DID_SERVICE_TYPE type;

    @SerializedName("serviceEndpoint")
    @Expose
    private List<String> serviceEndpoint;

    public Service() {
    }

    public Service(String id, DIDServiceType.DID_SERVICE_TYPE type, List<String> serviceEndpoint) {
        this.id = id;
        this.type = type;
        this.serviceEndpoint = serviceEndpoint;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public DIDServiceType.DID_SERVICE_TYPE getType() {
        return type;
    }

    public void setType(DIDServiceType.DID_SERVICE_TYPE type) {
        this.type = type;
    }

    public List<String> getServiceEndpoint() {
        return serviceEndpoint;
    }

    public void setServiceEndpoint(List<String> serviceEndpoint) {
        this.serviceEndpoint = serviceEndpoint;
    }

    public void fromJson(String val) {
        Gson gson = new Gson();
        Service obj = gson.fromJson(val, Service.class);

        this.id = obj.getId();
        this.type = obj.getType();
        this.serviceEndpoint = obj.getServiceEndpoint();
    }
}
