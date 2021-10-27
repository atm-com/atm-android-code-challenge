# Kotlin Multiplatform Mobile

### Publishing

* Local cocoapod build-to-path is configured
* Local Maven publishing is configured

### KMM TODO

* Publishing
    * Set up cocoapod to publish to a github package / repo so it can be imported using standard cocoapod process.
    * Configure Github package maven publishing (See https://github.com/atm-com/Android-Offer-Wall-SDK) for example / work in progress.
    * Configure passing through project variables. See above maven publishing project.
    * Set up Github actions to trigger a cocoapod/maven build publishing event when adding a git tag.
* Production-ize Networking
    * Existing networking has a hardcoded token. Pass this through using a library interface.
    * Headers in networking are limited
    * Configure interceptors to match LE/ATM standards
* Database
    * There is an open branch w/ beginnings of database support using SQLDelight.
    * It doesn't appear to generate the required DB class files. I ran into this issue previously when using SQLDelight so it's probably something simple to resolve. Once generated they should be usable.
* General
    * Platform specific params will need to be implemented in their given platform folders. IDFA, ANDROID_ID, etc.
    * Mask DB/Networking behind service tier. Don't expose them directly.
    * Consider obsfucation requirements around this project.
    * Consider moving this entire proof-of-concept into its own project apart from the code challenge.
    * Consider how the majority of this project can be implemented as a base-library so app-specific KMM projects can reference this one.
        * AKA, use the same networking and database base-layer as a root dependency. Then ATM/LE can extend for their own specific needs.