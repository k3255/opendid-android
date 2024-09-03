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

- 주제: DataModel
- 작성: Sangjun Kim
- 일자: 2024-07-11
- 버전: v1.0.0

| 버전   | 일자       | 변경 내용                 |
| ------ | ---------- | -------------------------|
| v1.0.0 | 2024-07-11 | 초기 작성                 |



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
            - [5.1.1. Profle](#511-profile)
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
    - [14. SYMMETRIC_CIPHER_TYPE](#4-symmetric_cipher_type)
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

`탈중앙 식별자를 위한 문서`

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
| context              | List\<String>             | JSON-LD context                        |    M    |   | 
| id                   | String               | DID 소유자의 did                        |    M    |   | 
| controller           | String               | DID controller의 did                   |    M    |   | 
| verificationMethod   | List\<VerificationMethod> | 공개키가 포함된 DID 키 목록                   |    M    | [VerificationMethod](#11-verificationmethod) | 
| assertionMethod      | List\<String>             | Assertion 키 이름 목록             |    O    |   | 
| authentication       | List\<String>             | Authentication 키 이름 목록         |    O    |   | 
| keyAgreement         | List\<String>             | Key Agreement 키 이름 목록         |    O    |   | 
| capabilityInvocation | List\<String>             | Capability Invocation 키 이름 목록  |    O    |   | 
| capabilityDelegation | List\<String>             | Capability Delegation 키 이름 목록  |    O    |   | 
| service              | List\<Service>            | 서비스 목록                        |    O    |[Service](#12-service)  | 
| created              |  String              | 생성 시간                            |    M    | | 
| updated              |  String              | 갱신 시간                            |    M    | | 
| versionId            |  String              | DID 버전 id                         |    M    | | 
| deactivated          |  Bool                | True: 비활성화, False: 활성화            |    M    |   | 
| proof                |  Proof               | 소유자 proof                            |    O    |[Proof](#4-proof)| 
| proofs               |  [Proof]             | 소유자 proof 목록                    |    O    |[Proof](#4-proof)| 

<br>

## 1.1. VerificationMethod

### Description

`공개키가 포함된 DID 키 목록`

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

| Name               | Type       | Description                            | **M/O** | **Note**              |
|--------------------|------------|----------------------------------------|---------|-----------------------|
| id                 | String     | 키 이름                               |    M    |                       | 
| type               | DID_KEY_TYPE | 키 종류                              |    M    | [DID_KEY_TYPE](#1-did_key_type) | 
| controller         | String     | 키 controller의 DID                   |    M    |                       | 
| publicKeyMultibase | String     | 공개키                       |    M    | 멀티베이스 인코딩됨  | 
| authType           | AUTH_TYPE   | 키 사용을 위한 인증 방법     |    M    | [AUTH_TYPE](#5-auth_type) | 

<br>

## 1.2. Service

### Description

`서비스 목록`

### Declaration

```java
public class Service {
    String id;
    DIDServiceType.DID_SERVICE_TYPE type;
    List<String> serviceEndpoint;
}
```

### Property

| Name            | Type           | Description                | **M/O** | **Note**                  |
|-----------------|----------------|----------------------------|---------|---------------------------|
| id              | String         | 서비스 id                 |    M    |                           | 
| type            | DID_SERVICE_TYPE | 서비스 종류               |    M    | [DID_SERVICE_TYPE](#2-did_service_type)| 
| serviceEndpoint | List\<String>       | List of 서비스로의 URL 목록 |    M    |                           | 

<br>

## 2. VerifiableCredential

### Description

`탈중앙화된 전자 인증서, 이하 VC`

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

| Name              | Type              | Description                      | **M/O** | **Note**                    |
|-------------------|-------------------|----------------------------------|---------|-----------------------------|
| context           | List\<String>          | JSON-LD context                  |    M    |                             |
| id                | String            | VC id                            |    M    |                             |
| type              | List\<String>          | VC 종류 목록                 |    M    |                             |
| issuer            | Issuer            | 발급처 정보               |    M    | [Issuer](#21-issuer)         |
| issuanceDate      | String            | 발급 시간                |    M    |                             |
| validFrom         | String            | VC의 유효 시작 시간  |    M    |                             |
| validUntil        | String            | VC의 만료 시간 |    M    |                             |
| encoding          | String            | VC 인코딩 종류                 |    M    | Default(UTF-8)              |
| formatVersion     | String            | VC 포맷 버전                |    M    |                             |
| language          | String            | VC 언어 코드                 |    M    |                             |
| evidence          | List\<Evidence>        | 증거                           |    M    | [Evidence](#22-evidence) |
| credentialSchema  | CredentialSchema  | Credential schema                |    M    | [CredentialSchema](#23-credentialschema)                            |
| credentialSubject | CredentialSubject | Credential subject               |    M    | [CredentialSubject](#24-credentialsubject)                            |
| proof             | VCProof           | 발급처 proof                     |    M    | [VCProof](#41-vcproof)                            |

<br>

## 2.1 Issuer

## Description

`이슈어 정보`

## Declaration

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
| id        | String | 이슈어 DID                      |    M    |                          |
| name      | String | 이슈어 name                     |    O    |                          |
| certVCRef | String | 가입증명서 URL                    |    O    |                          |

<br>

## 2.2 Evidence

## Description

`증거 서류 확인`

## Declaration

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

| Name             | Type         | Description                      | **M/O** | **Note**                 |
|------------------|--------------|----------------------------------|---------|--------------------------|
| id              | String       | 증거 정보의 URL                      |    O    |                          |
| type             | EVIDENCE_TYPE | 증거 종류                            |    M    | [EVIDENCE_TYPE](#6-evidence_type) |
| verifier         | String       | 증거 검증처                          |    M    |                          |
| evidenceDocument | String       | 증거 문서 이름                           |    M    |                          |
| subjectPresence  | PRESENCE     | 주체 표현 종류                       |    M    | [PRESENCE](#7-presence)        |
| documentPresence | PRESENCE     | 문서 표현 종류                         |    M    | [PRESENCE](#7-presence)   |

<br>

## 2.3 CredentialSchema

## Description

`Credential schema`

## Declaration

```java
public class CredentialSchema {
    String id;
    CredentialSchemaType.CREDENTIAL_SCHEMA_TYPE type;
}
```

## Property

| Name      | Type                 | Description           | **M/O** | **Note**                 |
|-----------|----------------------|-----------------------|---------|--------------------------|
| id        | String               |  VC schema URL    |    M    |                          |
| type      | CREDENTIAL_SCHEMA_TYPE | VC Schema 포맷 종류 |    M    |  [CREDENTIAL_SCHEMA_TYPE](#16-credential_schema_type)   |

<br>

## 2.4 CredentialSubject

## Description

`Credential subject`

## Declaration

```java
public class CredentialSubject {
    String id;
    List<Claim> claims;
}
```

## Property

| Name      | Type    | Description   | **M/O** | **Note**                 |
|-----------|---------|---------------|---------|--------------------------|
| id        | String  | 주체 DID   |    M    |                          |
| claims    | List\<Claim> | Claim 목록 |    M    | [Claim](#25-claim)           |

<br>

## 2.5 Claim

## Description

`주체 정보`

## Declaration

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

| Name      | Type                         | Description                  | **M/O** | **Note**                 |
|-----------|------------------------------|------------------------------|---------|--------------------------|
| code      | String                       | Claim 코드                   |    M    |                          |
| caption   | String                       | Claim 이름                   |    M    |                          |
| value     | String                       | Claim 값                  |    M    |                          |
| type      | CLAIM_TYPE                    | Claim 종류                   |    M    | [CLAIM_TYPE](#11-claim_type)         |
| format    | ClaimFormat                  | Claim 포맷                 |    M    | [CLAIM_FORMAT](#12-claim_format)           |
| hideValue | Bool                         | 값 숨김                   |    O    | Default(false)           |
| location  | LOCATION                     | 값 위치                   |    O    | Default(inline) <br> [LOCATION](#12-location) |
| digestSRI | String                       | Digest Subresource Integrity |    O    |                          |
| i18n      |Map\<String, Internationalization> | 국제화                  |    O    | Claim 값의 해시값 <br> [Internationalization](#26-internationalization) |

<br>

## 2.6 Internationalization

## Description

`국제화`

## Declaration

```java
public class Internationalization {
    String caption;
    String value;
    String digestSRI;

}
```

## Property

| Name      | Type   | Description                  | **M/O** | **Note**                 |
|-----------|--------|------------------------------|---------|--------------------------|
| caption   | String | Claim 이름                   |    M    |                          |
| value     | String | Claim 값                  |    O    |                          |
| digestSRI | String | Digest Subresource Integrity |    O    | Claim 값의 해시값      |

<br>

## 3. VerifiablePresentation

### Description

`주체 서명된 VC 목록, 이하 VP`

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

| Name                 | Type                   | Description                      | **M/O** | **Note**                 |
|----------------------|------------------------|----------------------------------|---------|--------------------------|
| context              | List\<String>               | JSON-LD context                  |    M    |                          |
| id                   | String                 | VP ID                            |    M    |                          |
| type                 | List\<String>               | VP 종류 목록                  |    M    |                          |
| holder               | String                 | 소유자 DID                       |    M    |                          |
| validFrom            | String                 | VP의 유효 시작 시간            |    M    |                          |
| validUntil           | String                 | VP의 만료 시간                 |    M    |                          |
| verifierNonce        | String                 | 검증자 nonce                   |    M    |                          |
| verifiableCredential | List\<VerifiableCredential> | VC 목록                       |    M    | [VerifiableCredential](#2-verifiablecredential)   |
| proof                | Proof                  | 소유자 proof                      |    O    | [Proof](#4-proof) | 
| proofs               | List\<Proof>                | 소유자 proof 목록             |    O    | [Proof](#4-proof)    | 

<br>

## 4. Proof

### Description

`소유자 proof`

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

| Name               | Type         | Description                      | **M/O** | **Note**                 |
|--------------------|--------------|----------------------------------|---------|--------------------------|
| created            | String       | 생성시간                 |    M    |    | 
| proofPurpose       | PROOF_PURPOSE | Proof 목적                    |    M    | [PROOF_PURPOSE](#3-proof_purpose) | 
| verificationMethod | String       | Proof 서명에 사용된 Key URL |    M    |                          | 
| type               | PROOF_TYPE    | Proof 종류                       |    O    | [PROOF_TYPE](#4-proof_type)   |
| proofValue         | String       | 서명값                         |    O    |                          |

<br>

## 4.1 VCProof

### Description

`발급처 proof`

### Declaration

```java
public class VCProof extends Proof {
    List<String> proofValueList;
}
```

### Property

| Name               | Type         | Description                      | **M/O** | **Note**                 |
|--------------------|--------------|----------------------------------|---------|--------------------------|
| created            | String       | 생성 시간                |    M    |        | 
| proofPurpose       | PROOF_PURPOSE | Proof 목적                    |    M    | [PROOF_PURPOSE](#3-proof_purpose)  | 
| verificationMethod | String       | Proof 서명에 사용된 Key URL |    M    |                          | 
| type               | PROOF_TYPE    | Proof 종류                       |    O    | [PROOF_TYPE](#4-proof_type)   |
| proofValue         | String       | 서명값                  |    O    |                          |
| proofValueList     | List\<String>     | 서명값 목록             |    O    |                          |

<br>

## 5. Profile

## 5.1 IssuerProfile

### Description

`발급처 프로파일`

### Declaration

```java
public class IssueProfile {
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

| Name        | Type        | Description           | **M/O** | **Note**                 |
|-------------|-------------|-----------------------|---------|--------------------------|
| id          | String      | 프로파일 ID            |    M    |                          |
| type        | PROFILE_TYPE | 프로파일 종류          |    M    | [PROFILE_TYPE](#8-profile_type)    |
| title       | String      | 프로파일 타이틀         |    M    |                          |
| description | String      | 프로파일 설명   |    O    |                          |
| logo        | LogoImage   | 로고 이미지            |    O    | [LogoImage](#53-logoimage)         |
| encoding    | String      | 프로파일 인코딩 종류 |    M    |                          |
| language    | String      | 프로파일 언어 코드 |    M    |                          |
| profile     | Profile     | 프로파일 컨텐츠      |    M    | [Profle](#511-profile)           |
| proof       | Proof       | 소유자 proof           |    O    | [Proof](#4-proof)      |

<br>

## 5.1.1 Profile

### Description

`프로파일 컨텐츠`

### Declaration

```java
public class Profile {
    ProviderDetail issuer;
    CredentialSchema credentialSchema;
    Process process;
}
```

### Property

| Name             | Type             | Description           | **M/O** | **Note**                 |
|------------------|------------------|-----------------------|---------|--------------------------|
| issuer           | ProviderDetail   | 발급처 정보    |    M    | [ProviderDetail](#54-providerdetail)   |
| credentialSchema | CredentialSchema | VC schema 정보 |    M    | [CredentialSchema](#5111-credentialschema)          |
| process          | Process          | 발급 절차       |    M    |  [Process](#5112-process)     |

<br>

## 5.1.1.1 CredentialSchema

### Description

`VC schema 정보`

### Declaration

```java
public class CredentialSchema {
    String id;
    CredentialSchemaType.CREDENTIAL_SCHEMA_TYPE type;
    String value;
}
```

### Property

| Name  | Type                 | Description           | **M/O** | **Note**                 |
|-------|----------------------|-----------------------|---------|--------------------------|
| id    | String               | VC schema URL     |    M    |                          |
| type  | CREDENTIAL_SCHEMA_TYPE | VC schema 포맷 종류 |    M    | [CREDENTIAL_SCHEMA_TYPE](#16-credential_schema_type)      |
| value | String               | VC schema             |    O    | 멀티베이스 인코딩됨     |

<br>

## 5.1.1.2 Process

### Description

`발급 절차`

### Declaration

```java
public class Process {
    List<String> endpoints;
    ReqE2e reqE2e;
    String issuerNonce;
}
```

### Property

| Name        | Type     | Description         | **M/O** | **Note**                 |
|-------------|----------|---------------------|---------|--------------------------|
| endpoints   | List\<String> | Endpoint 목록    |    M    |                          |
| reqE2e      | ReqE2e   | 요청 정보 |    M    | Proof 없음 <br> [ReqE2e](#55-reqe2e)     |
| issuerNonce | String   | 발급처 nonce        |    M    |                          |

<br>

## 5.2 VerifyProfile

### Description

`검증 프로파일`

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

| Name        | Type        | Description           | **M/O** | **Note**                 |
|-------------|-------------|-----------------------|---------|--------------------------|
| id          | String      | 프로파일 ID            |    M    |                          |
| type        | PROFILE_TYPE | 프로파일 종류          |    M    | [PROFILE_TYPE](#8-profile_type)         |
| title       | String      | 프로파일 타이틀         |    M    |                          |
| description | String      | 프로파일 설명   |    O    |                          |
| logo        | LogoImage   | 로고 이미지            |    O    |  [LogoImage](#53-logoimage)        |
| encoding    | String      | 프로파일 인코딩 종류 |    M    |                          |
| language    | String      | 프로파일 언어 코드 |    M    |                          |
| profile     | Profile     | 프로파일 컨텐츠      |    M    | [Profile](#521-profile)      |
| proof       | Proof       | 소유자 proof           |    O    | [Proof](#4-proof)       |

<br>

## 5.2.1 Profile

### Description

`프로파일 컨텐츠`

### Declaration

```java
public class Profile {
    ProviderDetail verifier;
    ProfileFilter filter;
    Process process;
}
```

### Property

| Name     | Type           | Description              | **M/O** | **Note**                 |
|----------|----------------|--------------------------|---------|--------------------------|
| verifier | ProviderDetail | 검증자 정보     |    M    |  [ProviderDetail](#54-providerdetail)       |
| filter   | ProfileFilter  | 제출을 위한 필터링 정보 |    M    | [ProfileFilter](#5211-profilefilter)          |
| process  | Process        | VP 제출 방법 |    M    |[Process](#5212-process)       |

<br>

## 5.2.1.1 ProfileFilter

### Description

`제출을 위한 필터링 정보`

### Declaration

```java
public class ProfileFilter {
    List<CredentialSchema> credentialSchemas;
}
```

### Property

| Name              | Type               | Description                                | **M/O** | **Note**                 |
|-------------------|--------------------|--------------------------------------------|---------|--------------------------|
| credentialSchemas | List\<CredentialSchema> | 제출가능한 VC Schema 별 Claim과 발급처           |    M    | [CredentialSchema](#52111-credentialschema)      |

<br>

## 5.2.1.1.1 CredentialSchema

### Description

`제출가능한 VC Schema 별 Claim과 발급처`

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

| Name           | Type                 | Description           | **M/O** | **Note**                 |
|----------------|----------------------|-----------------------|---------|--------------------------|
| id             | String               | VC schema URL     |    M    |                          |
| type           | CREDENTIAL_SCHEMA_TYPE | VC schema 포맷 종류 |    M    | [CREDENTIAL_SCHEMA_TYPE](#16-credential_schema_type)    |
| value          | String               | VC schema             |    O    | 멀티베이스 인코딩됨     |
| displayClaims  | List\<String>             | 사용자 화면에 노출될 claims 목록        |    O    |                          |
| requiredClaims | List\<String>             | 필요 claims 목록       |    O    |                          |
| allowedIssuers | List\<String>             | 허용된 발급처의 DID 목록       |    O    |                          |

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

| Name          | Type           | Description                    | **M/O** | **Note**                 |
|---------------|----------------|--------------------------------|---------|--------------------------|
| endpoints     | List\<String>       | Endpoint 목록               |    O    |                          |
| reqE2e        | ReqE2e         | 요청 정보            |    M    | Proof 없음 <br> [ReqE2e](#55-reqe2e)     |
| verifierNonce | String         | 발급처 nonce                   |    M    |                          |
| authType      | VERIFY_AUTH_TYPE | 제출용 인증수단                  |    O    | [VERIFY_AUTH_TYPE](#18-verify_auth_type)   |

<br>

## 5.3. LogoImage

### Description

`로고 이미지`

### Declaration

```java
public class LogoImage {
    private LOGO_IMAGE_TYPE format;
    private String link;
    private String value;
}
```

### Property

| Name   | Type          | Description         | **M/O** | **Note**                 |
|--------|---------------|---------------------|---------|--------------------------|
| format | LOGO_IMAGE_TYPE | 이미지 포맷       |    M    | [LOGO_IMAGE_TYPE](#9-logo_image_type)     |
| link   | String        | 로고 이미지 URL  |    O    | 멀티베이스 인코딩됨     |
| value  | String        | 이미지 값         |    O    | 멀티베이스 인코딩됨     |

<br>

## 5.4. ProviderDetail

### Description

`제공자 상세 정보`

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

| Name        | Type      | Description                       | **M/O** | **Note**                 |
|-------------|-----------|-----------------------------------|---------|--------------------------|
| did         | String    | 제공자 DID                      |    M    |                          |
| certVCRef   | String    | 가입증명서 URL              |    M    |                          |
| name        | String    | 제공자 이름                     |    M    |                          |
| description | String    | 제공자 설명              |    O    |                          |
| logo        | LogoImage | 로고 이미지                        |    O    | [LogoImage](#53-logoimage)          |
| ref         | String    | 참조 URL                     |    O    |                          |

<br>

## 5.5. ReqE2e

### Description

`E2E 요청 데이터`

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

| Name      | Type      | Description                                   | **M/O** | **Note**                 |
|-----------|-----------|-----------------------------------------------|---------|--------------------------|
| nonce     | String               | 대칭키 생성용 nonce  |    M    | 멀티베이스 인코딩됨     |
| curve     | ELLIPTIC_CURVE_TYPE    | 타원곡선 종류                  |    M    | [ELLIPTIC_CURVE_TYPE](#18-elliptic_curve_type)   |
| publicKey | String               | 암호화용 서버 공개키 |    M    | 멀티베이스 인코딩됨     |
| cipher    | SYMMETRIC_CIPHER_TYPE  | 암호화 종류                        |    M    | [SYMMETRIC_CIPHER_TYPE](#14-symmetric_cipher_type)  |
| padding   | SYMMETRIC_PADDING_TYPE | 패딩 종류                       |    M    | [SYMMETRIC_PADDING_TYPE](#13-symmetric_padding_type)   |
| proof     | Proof                | Key aggreement proof               |    O    | [Proof](#4-proof)    |

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

| Name              | Type              | Description              | **M/O** | **Note**                 |
|-------------------|-------------------|--------------------------|---------|--------------------------|
| id                | String            | VC schema URL       |    M    |                          |
| schema            | String            | VC schema 포맷 URL |    M    |                          |
| title             | String            | VC schema 이름           |    M    |                          |
| description       | String            | VC schema 설명     |    M    |                          |
| metadata          | VCMetadata        | VC metadata              |    M    |  [VCMetadata](#61-vcmetadata)   |
| credentialSubject | CredentialSubject | Credential subject       |    M    |  [CredentialSubject](#62-credentialsubject)   |

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
| language      | String | VC 기본 언어 |    M    |                          |
| formatVersion | String | VC 포맷 버전   |    M    |                          |

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

| Name   | Type    | Description          | **M/O** | **Note**                 |
|--------|---------|----------------------|---------|--------------------------|
| claims | List\<Claim> | Namespace 별 Claim    |    M    | [Claim](#621-claim)                         |

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

| Name      | Type       | Description              | **M/O** | **Note**                 |
|-----------|------------|--------------------------|---------|--------------------------|
| namespace | Namespace  | Claim namespace          |    M    |  [Namespace](#6211-namespace)      |
| items     | List\<ClaimDef> | Claim 정의 목록           |    M    | [ClaimDef](#6212-claimdef)  |

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
| name | String | Namespace 이름                |    M    |                          |
| ref  | String | Namespace 정보 URL             |    O    |                          |

<br>

## 6.2.1.2. ClaimDef

### Description

`Claim 정의`

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

| Name        | Type            | Description          | **M/O** | **Note**                 |
|-------------|-----------------|----------------------|---------|--------------------------|
| id          | String          | Claim ID             |    M    |                          |
| caption     | String          | Claim 이름            |    M    |                          |
| type        | CLAIM_TYPE       | Claim 종류            |    M    | [CLAIM_TYPE](#10-claim_type)         |
| format      | CLAIM_FORMAT     | Claim 포맷            |    M    |  [CLAIM_FORMAT](#11-claim_format)       |
| hideValue   | Bool            | 값 숨김                |    O    | Default(false)           |
| location    | LOCATION        | 값 위치                |    O    | Default(inline) <br> [LOCATION](#12-location)        |
| required    | Bool            | 필수여부               |    O    | Default(true)            |
| description | String          | Claim 설명             |    O    | Default("")              |
| i18n        | Map\<String, String> | 국제화                 |    O    |                          |

<br>

# Enumerators

## 1. DID_KEY_TYPE

### Description

`DID 키 종류`

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

`서비스 종류`

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

`Proof 목적`

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

`Proof 종류`

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

`키의 접근 방법을 가리킨다.`

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

`다중종류 배열을 위한 Evidence Enumerator`

### Declaration

```java
public enum EVIDENCE_TYPE {
    documentVerification("DocumentVerification");
}
```

<br>

## 7. PRESENCE

### Description

`표현 종류`

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

`프로파일 종류`

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

`로고 이미지 종류`

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

`Claim 종류`

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

`Claim 포맷`

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

`값 위치`

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

`패딩 옵션`

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

`암호화 종류`

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

`알고리즘 종류`

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

`Credential schema 종류`

### Declaration

```java
public enum CREDENTIAL_SCHEMA_TYPE {
    osdSchemaCredential("OsdSchemaCredential");
}
```

<br>

## 17. ELLIPTIC_CURVE_TYPE

### Description

`타원 곡선 종류`

### Declaration

```java
public enum ELLIPTIC_CURVE_TYPE {
    SECP256K1("Secp256k1"),
    SECP256R1("Secp256r1");
}
```

## 18. VERIFY_AUTH_TYPE

### Description

`키의 접근 방법과 제출 옵션을 가리킨다. AuthType과 유사하다.`

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

`데이터모델의 deserialize`

### Declaration

```java
public static <T> T deserialize(String jsonString, Class<T> clazz)
```

<br>

## 2. convertFrom

### Description

`AlgorithmType으로 변환 (ELLIPTIC_CURVE_TYPE / PROOF_TYPE / DID_KEY_TYPE)`

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

`AlgorithmType에서 해당 값으로 변환 (ELLIPTIC_CURVE_TYPE / PROOF_TYPE / DID_KEY_TYPE)`

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