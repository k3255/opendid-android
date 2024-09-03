# Android DataModel SDK Guide
This document is a guide for using the DataModel SDK, defining the data model used in the app and wallet SDK.



## S/W Specifications
| Category | Details                |
|------|----------------------------|
| OS  | Android 13|
| Language  | Java 17|
| IDE  | Android Studio 4|
| Build System  | Gradle 8.2 |
| Compatibility | Android API level 34 or higher  |

<br>

## Build Method
: Execute the export JAR task in the build.gradle file of this SDK project to generate a JAR file.
1. Open the `build.gradle` file of the project, and add the `export JAR` task as shown below.
```groovy
ext {
    version = "1.0.0"
}

task exportJar(type: Copy){
    from('build/intermediates/aar_main_jar/release/')
    into('../release/')
    include('classes.jar')
    rename('classes.jar', 'did-datamodel-sdk-aos-${version}.jar')
}
```
2. Open the `Gradle` window in Android Studio, and run the project's `Tasks > other > exportJar` task.
3. Once the execution is complete, the `did-datamodel-sdk-aos-1.0.0.jar` file will be created in the `release/` folder.

<br>

## SDK Application Method
1. Copy the `did-datamodel-sdk-aos-1.0.0.jar` file to the libs directory of the app project.
2. Add the following dependencies to the build.gradle of the app project.

```groovy
    implementation files('libs/did-datamodel-sdk-aos-1.0.0.jar')
    implementation 'com.google.code.gson:gson:2.10.1'
```
3. Sync `Gradle` to ensure the dependencies are properly added.

<br>


## Structure Specification
| Category      | Structure Document Link             |
|---------------|-------------------------------|
| DataModel     | [DataModel SDK](../../../docs/api/did-datamodel-sdk-aos/DataModel.md) |