/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.sdk.datamodel.common;

import org.omnione.did.sdk.datamodel.util.GsonWrapper;
import org.omnione.did.sdk.datamodel.util.JsonSortUtil;

public abstract class BaseObject {
    public String toJson() {
        GsonWrapper gson = new GsonWrapper();
        String json = gson.toJson(this);
        return JsonSortUtil.sortJsonString(gson, json);
    }

    public abstract void fromJson(String val);

}

