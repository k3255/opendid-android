---
puppeteer:
    pdf:
        format: A4
        displayHeaderFooter: true
        landscape: false
        scale: 0.8
        margin:
            top: 1.2cm
            right: 1cm
            bottom: 1cm
            left: 1cm
    image:
        quality: 100
        fullPage: false
---

Android DataModel SDK API
==

- Topic: DataModel
- Author: Sangjun Kim
- Date: 2024-07-11
- Version: v1.0.0

| Version | Date       | Changes                    |
| ------- | ---------- | -------------------------- |
| v1.0.0  | 2024-07-11 | Initial version            |



<div style="page-break-after: always;"></div>


# Contents
- [Models](#models)
    - [1. DIDDocument](#1-diddocument)
        - [1.1. VerificationMethod](#11-verificationmethod)
        - [1.2 Service](#12-service)
    - [2. VerifiableCredential](#2-verifiablecredential)
        - [2.1 Issuer](#21-issuer)
        - [2.2 Evidence](#22-evidence)
        - [2.3 CredentialSchema](#23-credentialschema)
        - [2.4 CredentialSubject](#24-credentialsubject)
        - [2.5 Claim](#25-claim)
        - [2.6 Internationalization](#26-internationalization)
    - [3. VerifiablePresentation](#3-verifiablepresentation)
    - [4. Proof](#4-proof)
        - [4.1 VCProof](#41-vcproof)
    - [5. Profile](#5-profile)
        - [5.1. IssuerProfile](#51-issuerprofile)
            - [5.1.1. Profile](#511-profile)
                - [5.1.1.1. CredentialSchema](#5111-credentialschema)
                - [5.1.1.2. Process](#5112-process)
        - [5.2 VerifyProfile](#51-verifyprofile)
            - [5.2.1. Profile](#521-profile)
                - [5.2.1.1. ProfileFilter](#5211-profilefilter)
                    - [5.2.1.1.1. CredentialSchema](#52111-credentialschema)
                - [5.2.1.2. Process](#5212-process)
        - [5.3. LogoImage](#53-logoimage)
        - [5.4. ProviderDetail](#54-providerdetail)
        - [5.5. ReqE2e](#55-reqe2e)
    - [6. VCSchema](#6-vcschema)
        - [6.1. VCMetadata](#61-vcmetadata)
        - [6.2. CredentialSubject](#62-credentialsubject)
            - [6.2.1. Claim](#621-claim)
                - [6.2.1.1. Namespace](#6211-namespace)
                - [6.2.1.2. ClaimDef](#6212-claimdef)
- [Enumerators](#enumerators)
    - [1. DID_KEY_TYPE](#1-did_key_type)
    - [2. DID_SERVICE_TYPE](#2-did_service_type)
    - [3. PROOF_PURPOSE](#3-proof_purpose)
    - [4. PROOF_TYPE](#4-proof_type)
    - [5. AUTH_TYPE](#5-auth_type)
    - [6. EVIDENCE_TYPE](#6-evidence_type)
    - [7. PRESENCE](#7-presence)
    - [8. PROFILE_TYPE](#8-profile_type)
    - [9. LOGO_IMAGE_TYPE](#9-logo_image_type)
    - [10. CLAIM_TYPE](#10-claim_type)
    - [11. CLAIM_FORMAT](#11-claim_format)
    - [12. LOCATION](#12-location)
    - [13. SYMMETRIC_PADDING_TYPE](#13-symmetric_padding_type)
    - [14. SYMMETRIC_CIPHER_TYPE](#14-symmetric_cipher_type)
    - [15. ALGORITHM_TYPE](#15-algorithm_type)
    - [16. CREDENTIAL_SCHEMA_TYPE](#16-credential_schema_type)
    - [17. ELLIPTIC_CURVE_TYPE](#17-elliptic_curve_type)
    - [18. VERIFY_AUTH_TYPE](#18-verify_auth_type)
- [Apis](#apis)
    - [1. deserialize](#1-deserialize)
    - [2. convertFrom](#2-convertfrom)
    - [3. convertTo](#3-convertto)
# Models

## 1. DIDDocument

### Description

`Document for Decentralized Identifiers`

### Declaration

```java
public class DIDDocument {

    @SerializedName("@context")
    List<String> context;
    String id;
    String controller;
    List<VerificationMethod> verificationMethod;
    List<String> assertionMethod;
    List<String> authentication;
    List<String> keyAgreement;
    List<String> capabilityInvocation;
    List<String> capabilityDelegation;
    List<Service> service;
    String created;
    String updated;
    String versionId;
    boolean deactivated;
    Proof proof;
    List<Proof> proofs;
}
```

### Property

| Name                 | Type                 | Description                            | **M/O** | **Note**                    |
|----------------------|----------------------|----------------------------------------|---------|-----------------------------|
| context              | List\<String>        | JSON-LD context                        |    M    |                             | 
| id                   | String               | DID owner's did                        |    M    |                             | 
| controller           | String               | DID controller's did                   |    M    |                             | 
| verificationMethod   | List\<VerificationMethod> | List of DID keys containing public keys |    M    | [VerificationMethod](#11-verificationmethod) | 
| assertionMethod      | List\<String>        | List of assertion key names            |    O    |                             | 
| authentication       | List\<String>        | List of authentication key names       |    O    |                             | 
| keyAgreement         | List\<String>        | List of key agreement key names        |    O    |                             | 
| capabilityInvocation | List\<String>        | List of capability invocation key names|    O    |                             | 
| capabilityDelegation | List\<String>        | List of capability delegation key names|    O    |                             | 
| service              | List\<Service>       | List of services                       |    O    | [Service](#12-service)      | 
| created              | String               | Creation time                          |    M    |                             | 
| updated              | String               | Update time                            |    M    |                             | 
| versionId            | String               | DID version id                         |    M    |                             | 
| deactivated          | Bool                 | True: Deactivated, False: Activated    |    M    |                             | 
| proof                | Proof                | Owner's proof                          |    O    | [Proof](#4-proof)           | 
| proofs               | [Proof]              | List of owner's proofs                 |    O    | [Proof](#4-proof)           | 

<br>

## 1.1. VerificationMethod

### Description

`List of DID keys containing public keys`

### Declaration

```java
public class VerificationMethod {
    String id;
    DIDKeyType.DID_KEY_TYPE type;
    String controller;
    String publicKeyMultibase;
    AuthType.AUTH_TYPE authType;
    String status;
}
```
### Property

| Name               | Type          | Description                            | **M/O** | **Note**                     |
|--------------------|---------------|----------------------------------------|---------|------------------------------|
| id                 | String        | Key name                               |    M    |                              | 
| type               | DID_KEY_TYPE  | Key type                               |    M    | [DID_KEY_TYPE](#1-did_key_type) | 
| controller         | String        | Key controller's DID                   |    M    |                              | 
| publicKeyMultibase | String        | Public key                             |    M    | Multibase encoded            | 
| authType           | AUTH_TYPE     | Authentication method for key usage    |    M    | [AUTH_TYPE](#5-auth_type)    | 

<br>

## 1.2. Service

### Description

`List of services`

### Declaration

```java
public class Service {
    String id;
    DIDServiceType.DID_SERVICE_TYPE type;
    List<String> serviceEndpoint;
}
```

### Property

| Name            | Type               | Description                        | **M/O** | **Note**                                 |
|-----------------|--------------------|------------------------------------|---------|------------------------------------------|
| id              | String             | Service id                         |    M    |                                          | 
| type            | DID_SERVICE_TYPE   | Service type                       |    M    | [DID_SERVICE_TYPE](#2-did_service_type)  | 
| serviceEndpoint | List\<String>      | List of URLs to the service        |    M    |                                          | 

<br>

## 2. VerifiableCredential

### Description

`Decentralized electronic certificate, hereafter referred to as VC`

### Declaration

```java
public class VerifiableCredential {

    @SerializedName("@context")
    List<String> context;
    String id;
    List<String> type;
    Issuer issuer;
    String issuanceDate;
    String validFrom;
    String validUntil;
    String encoding;
    String formatVersion;
    String language;
    List<Evidence> evidence;
    CredentialSchema credentialSchema;
    CredentialSubject credentialSubject;
    VCProof proof;
}
```

### Property

| Name              | Type                  | Description                        | **M/O** | **Note**                                      |
|-------------------|-----------------------|------------------------------------|---------|-----------------------------------------------|
| context           | List\<String>         | JSON-LD context                    |    M    |                                               |
| id                | String                | VC id                              |    M    |                                               |
| type              | List\<String>         | List of VC types                   |    M    |                                               |
| issuer            | Issuer                | Issuer information                 |    M    | [Issuer](#21-issuer)                          |
| issuanceDate      | String                | Issuance date                      |    M    |                                               |
| validFrom         | String                | Start date of VC validity          |    M    |                                               |
| validUntil        | String                | Expiration date of VC              |    M    |                                               |
| encoding          | String                | Encoding type of VC                |    M    | Default (UTF-8)                               |
| formatVersion     | String                | Format version of VC               |    M    |                                               |
| language          | String                | Language code of VC                |    M    |                                               |
| evidence          | List\<Evidence>       | Evidence                           |    M    | [Evidence](#22-evidence)                      |
| credentialSchema  | CredentialSchema      | Credential schema                  |    M    | [CredentialSchema](#23-credentialschema)      |
| credentialSubject | CredentialSubject     | Credential subject                 |    M    | [CredentialSubject](#24-credentialsubject)    |
| proof             | VCProof               | Issuer's proof                     |    M    | [VCProof](#41-vcproof)                        |

<br>

## 2.1 Issuer

### Description

`Issuer information`

### Declaration

```java
public class Issuer {
    String id;
    String name;
    String certVCRef;
}
```

## Property

| Name      | Type   | Description                       | **M/O** | **Note**                 |
|-----------|--------|-----------------------------------|---------|--------------------------|
| id        | String | Issuer DID                        |    M    |                          |
| name      | String | Issuer name                       |    O    |                          |
| certVCRef | String | Certificate URL                   |    O    |                          |

<br>

## 2.2 Evidence

### Description

`Verification of evidence documents`

### Declaration

```java
public class Evidence {
    String id;
    EvidenceType.EVIDENCE_TYPE type;
    String verifier;
    String evidenceDocument;
    Presence.PRESENCE subjectPresence;
    Presence.PRESENCE documentPresence;
}
```

## Property

| Name             | Type          | Description                      | **M/O** | **Note**                           |
|------------------|---------------|----------------------------------|---------|------------------------------------|
| id              | String        | URL of the evidence information  |    O    |                                    |
| type             | EVIDENCE_TYPE | Type of evidence                 |    M    | [EVIDENCE_TYPE](#6-evidence_type)  |
| verifier         | String        | Evidence verifier                |    M    |                                    |
| evidenceDocument | String        | Name of the evidence document    |    M    |                                    |
| subjectPresence  | PRESENCE      | Type of subject presence         |    M    | [PRESENCE](#7-presence)            |
| documentPresence | PRESENCE      | Type of document presence        |    M    | [PRESENCE](#7-presence)            |

<br>

## 2.3 CredentialSchema

### Description

`Credential schema`

### Declaration

```java
public class CredentialSchema {
    String id;
    CredentialSchemaType.CREDENTIAL_SCHEMA_TYPE type;
}
```

## Property

| Name      | Type                     | Description            | **M/O** | **Note**                                      |
|-----------|--------------------------|------------------------|---------|-----------------------------------------------|
| id        | String                   | VC schema URL          |    M    |                                               |
| type      | CREDENTIAL_SCHEMA_TYPE   | VC schema format type  |    M    | [CREDENTIAL_SCHEMA_TYPE](#16-credential_schema_type) |

<br>

## 2.4 CredentialSubject

### Description

`Credential subject`

### Declaration

```java
public class CredentialSubject {
    String id;
    List<Claim> claims;
}
```

## Property

| Name      | Type          | Description        | **M/O** | **Note**                  |
|-----------|---------------|--------------------|---------|---------------------------|
| id        | String        | Subject DID        |    M    |                           |
| claims    | List\<Claim>  | List of claims     |    M    | [Claim](#25-claim)        |

<br>

## 2.5 Claim

### Description

`Subject information`

### Declaration

```java
public class Claim {
    String code;
    String caption;
    String value;
    ClaimType.CLAIM_TYPE type;
    ClaimFormat.CLAIM_FORMAT format;
    boolean hideValue;
    Location.LOCATION location;
    String digestSRI;
    Map<String, Internationalization> i18n;
}
```

## Property

| Name      | Type                              | Description                    | **M/O** | **Note**                                  |
|-----------|-----------------------------------|--------------------------------|---------|-------------------------------------------|
| code      | String                            | Claim code                     |    M    |                                           |
| caption   | String                            | Claim name                     |    M    |                                           |
| value     | String                            | Claim value                    |    M    |                                           |
| type      | CLAIM_TYPE                        | Claim type                     |    M    | [CLAIM_TYPE](#11-claim_type)              |
| format    | CLAIM_FORMAT                      | Claim format                   |    M    | [CLAIM_FORMAT](#12-claim_format)          |
| hideValue | Bool                              | Hide value                     |    O    | Default (false)                           |
| location  | LOCATION                          | Value location                 |    O    | Default (inline) <br> [LOCATION](#12-location) |
| digestSRI | String                            | Digest Subresource Integrity   |    O    |                                           |
| i18n      | Map\<String, Internationalization> | Internationalization           |    O    | Hash of claim value <br> [Internationalization](#26-internationalization) |

<br>

## 2.6 Internationalization

### Description

`Internationalization`

### Declaration

```java
public class Internationalization {
    String caption;
    String value;
    String digestSRI;
}
```

## Property

| Name      | Type   | Description                  | **M/O** | **Note**                              |
|-----------|--------|------------------------------|---------|---------------------------------------|
| caption   | String | Claim name                   |    M    |                                       |
| value     | String | Claim value                  |    O    |                                       |
| digestSRI | String | Digest Subresource Integrity |    O    | Hash of claim value                   |

<br>

## 3. VerifiablePresentation

### Description

`List of VCs signed by the subject, hereafter referred to as VP`

### Declaration

```java
public class VerifiablePresentation {

    @SerializedName("@context")
    List<String> context;
    String id;
    List<String> type;
    String holder;
    String validFrom;
    String validUntil;
    String verifierNonce;
    List<VerifiableCredential> verifiableCredential;
    Proof proof;
    List<Proof> proofs;
}
```

### Property

| Name                 | Type                        | Description                      | **M/O** | **Note**                                       |
|----------------------|-----------------------------|----------------------------------|---------|-----------------------------------------------|
| context              | List\<String>               | JSON-LD context                  |    M    |                                               |
| id                   | String                      | VP ID                            |    M    |                                               |
| type                 | List\<String>               | List of VP types                 |    M    |                                               |
| holder               | String                      | Holder's DID                     |    M    |                                               |
| validFrom            | String                      | Start date of VP validity        |    M    |                                               |
| validUntil           | String                      | Expiration date of VP            |    M    |                                               |
| verifierNonce        | String                      | Verifier nonce                   |    M    |                                               |
| verifiableCredential | List\<VerifiableCredential> | List of VCs                      |    M    | [VerifiableCredential](#2-verifiablecredential) |
| proof                | Proof                       | Holder's proof                   |    O    | [Proof](#4-proof)                             | 
| proofs               | List\<Proof>                | List of holder's proofs          |    O    | [Proof](#4-proof)                             | 

<br>

## 4. Proof

### Description

`Holder's proof`

### Declaration

```java
public class Proof {
    String created;
    ProofPurpose.PROOF_PURPOSE proofPurpose;
    String verificationMethod;
    ProofType.PROOF_TYPE type;
    String proofValue;
}
```

### Property

| Name               | Type          | Description                      | **M/O** | **Note**                              |
|--------------------|---------------|----------------------------------|---------|---------------------------------------|
| created            | String        | Creation time                    |    M    |                                       | 
| proofPurpose       | PROOF_PURPOSE | Purpose of the proof             |    M    | [PROOF_PURPOSE](#3-proof_purpose)     | 
| verificationMethod | String        | Key URL used for the proof       |    M    |                                       | 
| type               | PROOF_TYPE    | Type of the proof                |    O    | [PROOF_TYPE](#4-proof_type)           |
| proofValue         | String        | Signature value                  |    O    |                                       |

<br>

## 4.1 VCProof

### Description

`Issuer's proof`

### Declaration

```java
public class VCProof extends Proof {
    List<String> proofValueList;
}
```

### Property

| Name               | Type          | Description                      | **M/O** | **Note**                              |
|--------------------|---------------|----------------------------------|---------|---------------------------------------|
| created            | String        | Creation time                    |    M    |                                       | 
| proofPurpose       | PROOF_PURPOSE | Purpose of the proof             |    M    | [PROOF_PURPOSE](#3-proof_purpose)     | 
| verificationMethod | String        | Key URL used for the proof       |    M    |                                       | 
| type               | PROOF_TYPE    | Type of the proof                |    O    | [PROOF_TYPE](#4-proof_type)           |
| proofValue         | String        | Signature value                  |    O    |                                       |
| proofValueList     | List\<String> | List of signature values         |    O    |                                       |

<br>

## 5. Profile

## 5.1 IssuerProfile

### Description

`Issuer profile`

### Declaration

```java
public class IssuerProfile {
    String id;
    ProfileType.PROFILE_TYPE type;
    String title;
    String description;
    LogoImage logo;
    String encoding;
    String language;
    Profile profile;
    Proof proof;
}
```

### Property

| Name        | Type          | Description           | **M/O** | **Note**                              |
|-------------|---------------|-----------------------|---------|---------------------------------------|
| id          | String        | Profile ID            |    M    |                                       |
| type        | PROFILE_TYPE  | Profile type          |    M    | [PROFILE_TYPE](#8-profile_type)       |
| title       | String        | Profile title         |    M    |                                       |
| description | String        | Profile description   |    O    |                                       |
| logo        | LogoImage     | Logo image            |    O    | [LogoImage](#53-logoimage)            |
| encoding    | String        | Profile encoding type |    M    |                                       |
| language    | String        | Profile language code |    M    |                                       |
| profile     | Profile       | Profile content       |    M    | [Profile](#511-profile)               |
| proof       | Proof         | Holder's proof        |    O    | [Proof](#4-proof)                     |

<br>

## 5.1.1 Profile

### Description

`Profile content`

### Declaration

```java
public class Profile {
    ProviderDetail issuer;
    CredentialSchema credentialSchema;
    Process process;
}
```

### Property

| Name             | Type               | Description          | **M/O** | **Note**                              |
|------------------|--------------------|----------------------|---------|---------------------------------------|
| issuer           | ProviderDetail     | Issuer information   |    M    | [ProviderDetail](#54-providerdetail)  |
| credentialSchema | CredentialSchema   | VC schema information|    M    | [CredentialSchema](#5111-credentialschema) |
| process          | Process            | Issuance process     |    M    | [Process](#5112-process)              |

<br>

## 5.1.1.1 CredentialSchema

### Description

`VC schema information`

### Declaration

```java
public class CredentialSchema {
    String id;
    CredentialSchemaType.CREDENTIAL_SCHEMA_TYPE type;
    String value;
}
```

### Property

| Name  | Type                     | Description            | **M/O** | **Note**                                           |
|-------|--------------------------|------------------------|---------|----------------------------------------------------|
| id    | String                   | VC schema URL          |    M    |                                                    |
| type  | CREDENTIAL_SCHEMA_TYPE   | VC schema format type  |    M    | [CREDENTIAL_SCHEMA_TYPE](#16-credential_schema_type) |
| value | String                   | VC schema              |    O    | Multibase encoded                                  |

<br>

## 5.1.1.2 Process

### Description

`Issuance process`

### Declaration

```java
public class Process {
    List<String> endpoints;
    ReqE2e reqE2e;
    String issuerNonce;
}
```

### Property

| Name        | Type              | Description         | **M/O** | **Note**                            |
|-------------|-------------------|---------------------|---------|-------------------------------------|
| endpoints   | List\<String>     | List of endpoints   |    M    |                                     |
| reqE2e      | ReqE2e            | Request information |    M    | No proof <br> [ReqE2e](#55-reqe2e)  |
| issuerNonce | String            | Issuer nonce        |    M    |                                     |

<br>

## 5.2 VerifyProfile

### Description

`Verification profile`

### Declaration

```java
public class VerifyProfile {
    String id;
    ProfileType.PROFILE_TYPE type;
    String title;
    String description;
    LogoImage logo;
    String encoding;
    String language;
    Profile profile;
    Proof proof;
}
```

### Property

| Name        | Type          | Description           | **M/O** | **Note**                              |
|-------------|---------------|-----------------------|---------|---------------------------------------|
| id          | String        | Profile ID            |    M    |                                       |
| type        | PROFILE_TYPE  | Profile type          |    M    | [PROFILE_TYPE](#8-profile_type)       |
| title       | String        | Profile title         |    M    |                                       |
| description | String        | Profile description   |    O    |                                       |
| logo        | LogoImage     | Logo image            |    O    | [LogoImage](#53-logoimage)            |
| encoding    | String        | Profile encoding type |    M    |                                       |
| language    | String        | Profile language code |    M    |                                       |
| profile     | Profile       | Profile content       |    M    | [Profile](#521-profile)               |
| proof       | Proof         | Holder's proof        |    O    | [Proof](#4-proof)                     |

<br>

## 5.2.1 Profile

### Description

`Profile content`

### Declaration

```java
public class Profile {
    ProviderDetail verifier;
    ProfileFilter filter;
    Process process;
}
```

### Property

| Name     | Type           | Description              | **M/O** | **Note**                              |
|----------|----------------|--------------------------|---------|---------------------------------------|
| verifier | ProviderDetail | Verifier information     |    M    | [ProviderDetail](#54-providerdetail)  |
| filter   | ProfileFilter  | Filtering information for Presentation |    M    | [ProfileFilter](#5211-profilefilter)  |
| process  | Process        | VP Presentation process    |    M    | [Process](#5212-process)              |

<br>

## 5.2.1.1 ProfileFilter

### Description

`Filtering information for Presentation`

### Declaration

```java
public class ProfileFilter {
    List<CredentialSchema> credentialSchemas;
}
```

### Property

| Name              | Type                      | Description                                | **M/O** | **Note**                                   |
|-------------------|---------------------------|--------------------------------------------|---------|--------------------------------------------|
| credentialSchemas | List\<CredentialSchema>   | Claims and issuers per submitable VC Schema|    M    | [CredentialSchema](#52111-credentialschema)|

<br>

## 5.2.1.1.1 CredentialSchema

### Description

`Claims and issuers per submittable VC Schema`

### Declaration

```java
 public class CredentialSchema {
    String id;
    CredentialSchemaType.CREDENTIAL_SCHEMA_TYPE type;
    String value;
    List<String> displayClaims;
    List<String> requiredClaims;
    List<String> allowedIssuers;
}
```

### Property

| Name           | Type                     | Description                      | **M/O** | **Note**                                      |
|----------------|--------------------------|----------------------------------|---------|-----------------------------------------------|
| id             | String                   | VC schema URL                    |    M    |                                               |
| type           | CREDENTIAL_SCHEMA_TYPE   | VC schema format type            |    M    | [CREDENTIAL_SCHEMA_TYPE](#16-credential_schema_type) |
| value          | String                   | VC schema                        |    O    | Multibase encoded                             |
| displayClaims  | List\<String>            | List of claims to display to user|    O    |                                               |
| requiredClaims | List\<String>            | List of required claims          |    O    |                                               |
| allowedIssuers | List\<String>            | List of allowed issuer DIDs      |    O    |                                               |

<br>

## 5.2.1.2 Process

### Description

`Method for VP submission`

### Declaration

```java
public class Process {
    List<String> endpoints;
    ReqE2e reqE2e;
    String verifierNonce;
    VerifyAuthType.VERIFY_AUTH_TYPE authType;
}
```

### Property

| Name          | Type                  | Description                    | **M/O** | **Note**                              |
|---------------|-----------------------|--------------------------------|---------|---------------------------------------|
| endpoints     | List\<String>         | List of endpoints              |    O    |                                       |
| reqE2e        | ReqE2e                | Request information            |    M    | No proof <br> [ReqE2e](#55-reqe2e)    |
| verifierNonce | String                | Issuer nonce                   |    M    |                                       |
| authType      | VERIFY_AUTH_TYPE      | Authentication method for submission |    O    | [VERIFY_AUTH_TYPE](#18-verify_auth_type) |

<br>

## 5.3. LogoImage

### Description

`Logo image`

### Declaration

```java
public class LogoImage {
    private LOGO_IMAGE_TYPE format;
    private String link;
    private String value;
}
```

### Property

| Name   | Type               | Description         | **M/O** | **Note**                              |
|--------|--------------------|---------------------|---------|---------------------------------------|
| format | LOGO_IMAGE_TYPE    | Image format        |    M    | [LOGO_IMAGE_TYPE](#9-logo_image_type) |
| link   | String             | Logo image URL      |    O    | Multibase encoded                     |
| value  | String             | Image value         |    O    | Multibase encoded                     |

<br>

## 5.4. ProviderDetail

### Description

`Provider details`

### Declaration

```java
public class ProviderDetail {
    String did;
    String certVCRef;
    String name;
    String description;
    LogoImage logo;
    String ref;
}
```

### Property

| Name        | Type      | Description                       | **M/O** | **Note**                              |
|-------------|-----------|-----------------------------------|---------|---------------------------------------|
| did         | String    | Provider DID                      |    M    |                                       |
| certVCRef   | String    | Certificate URL                   |    M    |                                       |
| name        | String    | Provider name                     |    M    |                                       |
| description | String    | Provider description              |    O    |                                       |
| logo        | LogoImage | Logo image                        |    O    | [LogoImage](#53-logoimage)            |
| ref         | String    | Reference URL                     |    O    |                                       |

<br>

## 5.5. ReqE2e

### Description

`E2E request data`

### Declaration

```java
public class ReqE2e {
    String nonce;
    EllipticCurveType.ELLIPTIC_CURVE_TYPE curve;
    String publicKey;
    SymmetricCipherType.SYMMETRIC_CIPHER_TYPE cipher;
    SymmetricPaddingType.SYMMETRIC_PADDING_TYPE padding;
    Proof proof;
}
```

### Property

| Name      | Type                     | Description                                   | **M/O** | **Note**                                    |
|-----------|--------------------------|-----------------------------------------------|---------|---------------------------------------------|
| nonce     | String                   | Nonce for symmetric key generation            |    M    | Multibase encoded                           |
| curve     | ELLIPTIC_CURVE_TYPE      | Type of elliptic curve                        |    M    | [ELLIPTIC_CURVE_TYPE](#17-elliptic_curve_type) |
| publicKey | String                   | Server public key for encryption              |    M    | Multibase encoded                           |
| cipher    | SYMMETRIC_CIPHER_TYPE    | Type of encryption                            |    M    | [SYMMETRIC_CIPHER_TYPE](#14-symmetric_cipher_type) |
| padding   | SYMMETRIC_PADDING_TYPE   | Type of padding                               |    M    | [SYMMETRIC_PADDING_TYPE](#13-symmetric_padding_type) |
| proof     | Proof                    | Key agreement proof                           |    O    | [Proof](#4-proof)                           |

<br>

## 6. VCSchema

### Description

`VC schema`

### Declaration

```java
public class VCSchema {
    String id;
    String schema;
    String title;
    String description;
    VCMetadata metadata;
    CredentialSubject credentialSubject;
}
```

### Property

| Name              | Type              | Description              | **M/O** | **Note**                                    |
|-------------------|-------------------|--------------------------|---------|---------------------------------------------|
| id                | String            | VC schema URL            |    M    |                                             |
| schema            | String            | VC schema format URL     |    M    |                                             |
| title             | String            | VC schema title          |    M    |                                             |
| description       | String            | VC schema description    |    M    |                                             |
| metadata          | VCMetadata        | VC metadata              |    M    | [VCMetadata](#61-vcmetadata)                |
| credentialSubject | CredentialSubject | Credential subject       |    M    | [CredentialSubject](#62-credentialsubject)  |

<br>

## 6.1. VCMetadata

### Description

`VC Metadata`

### Declaration

```java
public class VCMetadata {
    String language;
    String formatVersion;
}
```

### Property

| Name          | Type   | Description         | **M/O** | **Note**                 |
|---------------|--------|---------------------|---------|--------------------------|
| language      | String | Default language of VC |    M    |                          |
| formatVersion | String | VC format version   |    M    |                          |

<br>

## 6.2. CredentialSubject

### Description

`Credential Subject`

### Declaration

```java
public class CredentialSubject {
    List<Claim> claims;
}
```

### Property

| Name   | Type              | Description          | **M/O** | **Note**                 |
|--------|-------------------|----------------------|---------|--------------------------|
| claims | List\<Claim>      | Claims by namespace  |    M    | [Claim](#621-claim)      |

<br>

## 6.2.1. Claim

### Description

`Claim`

### Declaration

```java
public class Claim {
    Namespace namespace;
    List<ClaimDef> items;
}
```

### Property

| Name      | Type              | Description              | **M/O** | **Note**                              |
|-----------|-------------------|--------------------------|---------|---------------------------------------|
| namespace | Namespace         | Claim namespace          |    M    | [Namespace](#6211-namespace)          |
| items     | List\<ClaimDef>   | List of claim definitions|    M    | [ClaimDef](#6212-claimdef)            |

<br>

## 6.2.1.1. Namespace

### Description

`Claim namespace`

### Declaration

```java
public class Namespace {
    String id;
    String name;
    String ref;
}
```

### Property

| Name | Type   | Description                   | **M/O** | **Note**                 |
|------|--------|-------------------------------|---------|--------------------------|
| id   | String | Claim namespace               |    M    |                          |
| name | String | Namespace name                |    M    |                          |
| ref  | String | Namespace information URL     |    O    |                          |

<br>

## 6.2.1.2. ClaimDef

### Description

`Claim definition`

### Declaration

```java
public class ClaimDef {
    String id;
    String caption;
    ClaimType.CLAIM_TYPE type;
    ClaimFormat.CLAIM_FORMAT format;
    boolean hideValue = false;
    Location.LOCATION location;
    boolean required = true;
    String description = "";
    Map<String, String> i18n;
}
```

### Property

| Name        | Type                   | Description          | **M/O** | **Note**                                   |
|-------------|------------------------|----------------------|---------|--------------------------------------------|
| id          | String                 | Claim ID             |    M    |                                            |
| caption     | String                 | Claim name           |    M    |                                            |
| type        | CLAIM_TYPE             | Claim type           |    M    | [CLAIM_TYPE](#10-claim_type)               |
| format      | CLAIM_FORMAT           | Claim format         |    M    | [CLAIM_FORMAT](#11-claim_format)           |
| hideValue   | Bool                   | Hide value           |    O    | Default(false)                             |
| location    | LOCATION               | Value location       |    O    | Default(inline) <br> [LOCATION](#12-location) |
| required    | Bool                   | Required             |    O    | Default(true)                              |
| description | String                 | Claim description    |    O    | Default("")                                |
| i18n        | Map\<String, String>   | Internationalization |    O    |                                            |

<br>

# Enumerators

## 1. DID_KEY_TYPE

### Description

`DID key types`

### Declaration
```java
public enum DID_KEY_TYPE {
    rsaVerificationKey2018("RsaVerificationKey2018"),
    secp256k1VerificationKey2018("Secp256k1VerificationKey2018"),
    secp256r1VerificationKey2018("Secp256r1VerificationKey2018");
}
```
<br>

## 2. DID_SERVICE_TYPE

### Description

`Service types`

### Declaration
```java
public enum DID_SERVICE_TYPE {
    linkedDomains("LinkedDomains"),
    credentialRegistry("CredentialRegistry");
}
```

<br>

## 3. PROOF_PURPOSE

### Description

`Proof purposes`

### Declaration
```java
public enum PROOF_PURPOSE {
    assertionMethod("assertionMethod"),
    authentication("authentication"),
    keyAgreement("keyAgreement"),
    capabilityInvocation("capabilityInvocation"),
    capabilityDelegation("capabilityDelegation");
}
```

<br>

## 4. PROOF_TYPE

### Description

`Proof types`

### Declaration

```java
public enum PROOF_TYPE {
    rsaSignature2018("RsaSignature2018"),
    secp256k1Signature2018("Secp256k1Signature2018"),
    secp256r1Signature2018("Secp256r1Signature2018");
}
```

<br>

## 5. AUTH_TYPE

### Description

`Indicates the method of accessing the key`

### Declaration

```java
public enum AUTH_TYPE {
    FREE(1),
    PIN(2),
    BIO(4);
}
```

<br>

## 6. EVIDENCE_TYPE

### Description

`Evidence Enumerator for Multi-type Arrays`

### Declaration

```java
public enum EVIDENCE_TYPE {
    documentVerification("DocumentVerification");
}
```

<br>

## 7. PRESENCE

### Description

`Presence types`

### Declaration

```java
public enum PRESENCE {
    physical("Physical"),
    digital("Digital");
}
```

<br>

## 8. PROFILE_TYPE

### Description

`Profile types`

### Declaration

```java
public enum PROFILE_TYPE {
    issueProfile("IssueProfile"),
    verifyProfile("VerifyProfile");
}
```

<br>

## 9. LOGO_IMAGE_TYPE

### Description

`Logo image types`

### Declaration

```java
public enum LOGO_IMAGE_TYPE {
    jpg("jpg"),
    png("png");
}
```

<br>

## 10. CLAIM_TYPE

### Description

`Claim types`

### Declaration

```java
public enum CLAIM_TYPE {
    text("text"),
    image("image"),
    document("document");
}
```

<br>

## 11. CLAIM_FORMAT

### Description

`Claim formats`

### Declaration

```java
public enum CLAIM_FORMAT {
    plain("plain"),
    html("html"),
    xml("xml"),
    csv("csv"),
    png("png"),
    jpg("jpg"),
    gif("gif"),
    txt("txt"),
    pdf("pdf"),
    word("word");
}
```

<br>

## 12. LOCATION

### Description

`Value location`

### Declaration

```java
public enum LOCATION {
    inline("inline"),
    remote("remote"),
    attach("attach");
}
```

<br>

## 13. SYMMETRIC_PADDING_TYPE

### Description

`Padding options for symmetric encryption`

### Declaration

```java
public enum SYMMETRIC_PADDING_TYPE {
    NOPAD("NOPAD"),
    PKCS5("PKCS5");
}
```

<br>

## 14. SYMMETRIC_CIPHER_TYPE

### Description

`Types of symmetric encryption algorithms`

### Declaration

```java
public enum SYMMETRIC_CIPHER_TYPE {
    AES128CBC("AES-128-CBC"),
    AES128ECB("AES-128-ECB"),
    AES256CBC("AES-256-CBC"),
    AES256ECB("AES-256-ECB");
}
```

<br>

## 15. ALGORITHM_TYPE

### Description

`Types of algorithms`

### Declaration

```java
public enum ALGORITHM_TYPE {
    RSA("Rsa"),
    SECP256K1("Secp256k1"),
    SECP256R1("Secp256r1");
}
```

<br>

## 16. CREDENTIAL_SCHEMA_TYPE

### Description

`Types of credential schemas`

### Declaration

```java
public enum CREDENTIAL_SCHEMA_TYPE {
    osdSchemaCredential("OsdSchemaCredential");
}
```

<br>

## 17. ELLIPTIC_CURVE_TYPE

### Description

`Types of elliptic curves`

### Declaration

```java
public enum ELLIPTIC_CURVE_TYPE {
    SECP256K1("Secp256k1"),
    SECP256R1("Secp256r1");
}
```

<br>

## 18. VERIFY_AUTH_TYPE

### Description

`Indicates access methods and submission options for keys. Similar to AuthType.`

### Declaration

```java
public enum VERIFY_AUTH_TYPE {
    ANY(0x00000000),
    FREE(0x00000001),
    PIN(0x00000002),
    BIO(0x00000004),
    PIN_OR_BIO(0x00000006),
    PIN_AND_BIO(0x00008006);
}
```

<br>

# APIs

## 1. deserialize

### Description

`Deserializes a JSON string into a specified data model object.`

### Declaration

```java
public static <T> T deserialize(String jsonString, Class<T> clazz)
```

<br>

## 2. convertFrom

### Description

`Converts an AlgorithmType into corresponding enum values(ELLIPTIC_CURVE_TYPE / PROOF_TYPE / DID_KEY_TYPE)`

### Declaration

```java
public static ELLIPTIC_CURVE_TYPE convertFrom(AlgorithmType.ALGORITHM_TYPE type){
    switch (type) {
        case SECP256K1:
            return ELLIPTIC_CURVE_TYPE.SECP256K1;
        case SECP256R1:
            return ELLIPTIC_CURVE_TYPE.SECP256R1;
        default:
            throw new RuntimeException();
    }
}

public static PROOF_TYPE convertFrom(AlgorithmType.ALGORITHM_TYPE type){
    switch (type) {
        case RSA:
            return PROOF_TYPE.rsaSignature2018;
        case SECP256K1:
            return PROOF_TYPE.secp256k1Signature2018;
        case SECP256R1:
            return PROOF_TYPE.secp256r1Signature2018;
        default:
            throw new RuntimeException();
    }
}

public static DID_KEY_TYPE convertFrom(AlgorithmType.ALGORITHM_TYPE type){
    switch (type) {
        case RSA:
            return DID_KEY_TYPE.rsaVerificationKey2018;
        case SECP256K1:
            return DID_KEY_TYPE.secp256k1VerificationKey2018;
        case SECP256R1:
            return DID_KEY_TYPE.secp256r1VerificationKey2018;
        default:
            throw new RuntimeException();
    }
}
```

<br>

## 3. convertTo

### Description

`Converts from (ELLIPTIC_CURVE_TYPE / PROOF_TYPE / DID_KEY_TYPE) to the corresponding AlgorithmType enum value.`

### Declaration

```java
public static AlgorithmType.ALGORITHM_TYPE convertTo(ELLIPTIC_CURVE_TYPE type){
    switch (type) {
        case SECP256K1:
            return AlgorithmType.ALGORITHM_TYPE.SECP256K1;
        case SECP256R1:
            return AlgorithmType.ALGORITHM_TYPE.SECP256R1;
        default:
            throw new RuntimeException();
    }
}

public static AlgorithmType.ALGORITHM_TYPE convertTo(PROOF_TYPE type){
    switch (type) {
        case rsaSignature2018:
            return AlgorithmType.ALGORITHM_TYPE.RSA;
        case secp256k1Signature2018:
            return AlgorithmType.ALGORITHM_TYPE.SECP256K1;
        case secp256r1Signature2018:
            return AlgorithmType.ALGORITHM_TYPE.SECP256R1;
        default:
            throw new RuntimeException();
    }
}

public static AlgorithmType.ALGORITHM_TYPE convertTo(DID_KEY_TYPE type){
    switch (type) {
        case rsaVerificationKey2018:
            return AlgorithmType.ALGORITHM_TYPE.RSA;
        case secp256k1VerificationKey2018:
            return AlgorithmType.ALGORITHM_TYPE.SECP256K1;
        case secp256r1VerificationKey2018:
            return AlgorithmType.ALGORITHM_TYPE.SECP256R1;
        default:
            throw new RuntimeException();
    }
}
```