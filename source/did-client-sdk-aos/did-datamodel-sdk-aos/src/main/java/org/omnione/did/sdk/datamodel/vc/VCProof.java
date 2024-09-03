/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.sdk.datamodel.vc;

import org.omnione.did.sdk.datamodel.common.Proof;

import java.util.List;

public class VCProof extends Proof {
    private List<String> proofValueList;

    public List<String> getProofValueList() {
        return proofValueList;
    }

    public void setProofValueList(List<String> proofValueList) {
        this.proofValueList = proofValueList;
    }
}
