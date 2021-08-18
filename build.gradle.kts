// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    val compose_version by extra("1.0.0")
    val apollo_version by extra("2.5.4")
    val lifecycle_version by extra("2.3.1")
    repositories {
        google()
        maven(url = "https://maven.google.com")
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.0.0-beta03")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.10")
        classpath("com.apollographql.apollo:apollo-gradle-plugin:$apollo_version")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.kts files
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}