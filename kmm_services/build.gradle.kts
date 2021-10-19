import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    kotlin("native.cocoapods")
    id("com.squareup.sqldelight")
    id("com.apollographql.apollo3")
    id("com.android.library")
    id("maven-publish")
}

group = "com.antmoney.shared"
version = "1.0.0"

kotlin {
    android {
        publishLibraryVariants("release", "debug")
    }

    val iosTarget: (String, KotlinNativeTarget.() -> Unit) -> KotlinNativeTarget = when {
        System.getenv("SDK_NAME")?.startsWith("iphoneos") == true -> ::iosArm64
//        System.getenv("NATIVE_ARCH")?.startsWith("arm") == true -> ::iosSimulatorArm64
        else -> ::iosX64
    }

    iosTarget("ios") {
//        binaries {
//            framework {
//                baseName = "kmm_shared"
//            }
//        }
    }

    cocoapods {
        summary = "KMM Shared Service Tier"
        homepage = "Link to the Shared Module homepage"
        ios.deploymentTarget = "13.0"
        frameworkName = "kmm_services"
//        this.specRepos {
//            this.url("https://github.com/atm-com/atm-ios-specs.git")
//        }

        podfile = project.file("/Users/esteban/Repos/atm-ios-code-challenge/atm-code-challenge/Podfile")
        // set path to your ios project podfile, e.g. podfile = project.file("../iosApp/Podfile")
        // Maps custom Xcode configuration to NativeBuildType
//        xcodeConfigurationToNativeBuildType["CUSTOM_DEBUG"] = NativeBuildType.DEBUG
//        xcodeConfigurationToNativeBuildType["CUSTOM_RELEASE"] = NativeBuildType.RELEASE
    }
    
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("com.apollographql.apollo3:apollo-runtime:${rootProject.extra["apolloVersion"]}")
                implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.5.2")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val androidMain by getting {
            dependsOn(commonMain)
            dependencies {
                implementation("com.squareup.sqldelight:android-driver:${rootProject.extra["sqlDelightVersion"]}")
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("junit:junit:4.13.2")
            }
        }
        val iosMain by getting {
            dependencies {
                implementation("com.squareup.sqldelight:native-driver:${rootProject.extra["sqlDelightVersion"]}")

            }
        }
        val iosTest by getting
    }

//    val publicationsFromMainHost = listOf(jvm(), js()).map { it.name } + "kotlinMultiplatform"
//    publishing {
//        publications {
//            matching { it.name in publicationsFromMainHost }.all {
//                val targetPublication = this@all
//                tasks.withType<AbstractPublishToMaven>()
//                    .matching { it.publication == targetPublication }
//                    .configureEach { onlyIf { findProperty("isMainHost") == "true" } }
//            }
//        }
//    }
}

apollo {
    customScalarsMapping.put("ISO8601DateTime", "java.util.Date")
    srcDir(file("src/commonMain/graphql/com/antmoney/kmm_services"))
}

android {
    compileSdk = 30
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdk = 21
        targetSdk = 30
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

sqldelight {
    database("KmmServicesDB") {
        packageName = "com.antmoney.kmm_services"
        sourceFolders = listOf("sqldelight")
//        schemaOutputDirectory = file("build/sqldelight")
        verifyMigrations = true
    }
    linkSqlite = false
}