/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.sdk.core.didmanager.datamodel;

import org.omnione.did.sdk.core.storagemanager.datamodel.Meta;

public class DIDMeta extends Meta {
    String did;

    public String getDID() {
        return did;
    }

    public void setDID(String did) {
        this.did = did;
    }
}
