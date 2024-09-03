/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.sdk.datamodel.common;

import java.util.List;

public interface ProofContainer {
    Proof getProof();
    void setProof(Proof proof);
    List<Proof> getProofs();
    void setProofs(List<Proof> proofs);
    String toJson();
    void fromJson(String val);

}
