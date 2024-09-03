/* 
 * Copyright 2024 Raonsecure
 */

package org.omnione.did.sdk.datamodel.profile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.omnione.did.sdk.datamodel.common.Proof;
import org.omnione.did.sdk.datamodel.common.enums.SymmetricCipherType;
import org.omnione.did.sdk.datamodel.common.enums.SymmetricPaddingType;
import org.omnione.did.sdk.datamodel.common.enums.EllipticCurveType;

public class ReqE2e {
    @SerializedName("nonce")
    @Expose
    private String nonce;

    @SerializedName("curve")
    @Expose
    private EllipticCurveType.ELLIPTIC_CURVE_TYPE curve;

    @SerializedName("publicKey")
    @Expose
    private String publicKey;

    @SerializedName("cipher")
    @Expose
    private SymmetricCipherType.SYMMETRIC_CIPHER_TYPE cipher;

    @SerializedName("padding")
    @Expose
    private SymmetricPaddingType.SYMMETRIC_PADDING_TYPE padding;

    @SerializedName("proof")
    @Expose
    private Proof proof; //keyagree proof

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public EllipticCurveType.ELLIPTIC_CURVE_TYPE getCurve() {
        return curve;
    }

    public void setCurve(EllipticCurveType.ELLIPTIC_CURVE_TYPE curve) {
        this.curve = curve;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public SymmetricCipherType.SYMMETRIC_CIPHER_TYPE getCipher() {
        return cipher;
    }

    public void setCipher(SymmetricCipherType.SYMMETRIC_CIPHER_TYPE cipher) {
        this.cipher = cipher;
    }

    public SymmetricPaddingType.SYMMETRIC_PADDING_TYPE getPadding() {
        return padding;
    }

    public void setPadding(SymmetricPaddingType.SYMMETRIC_PADDING_TYPE padding) {
        this.padding = padding;
    }

    public Proof getProof() {
        return proof;
    }

    public void setProof(Proof proof) {
        this.proof = proof;
    }
}
