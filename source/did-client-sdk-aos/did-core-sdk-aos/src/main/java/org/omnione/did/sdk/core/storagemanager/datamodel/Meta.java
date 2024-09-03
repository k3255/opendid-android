/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.sdk.core.storagemanager.datamodel;

import org.omnione.did.sdk.datamodel.util.GsonWrapper;
import org.omnione.did.sdk.datamodel.util.JsonSortUtil;

public class Meta {
    public String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String toJson() {
        GsonWrapper gson = new GsonWrapper();
        String json = gson.toJson(this);
        return JsonSortUtil.sortJsonString(gson, json);
    }
}
