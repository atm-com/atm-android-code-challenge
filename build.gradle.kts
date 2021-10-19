// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    val composeVersion by extra("1.0.2")
    val apolloVersion by extra("3.0.0-alpha03")
    val lifecycleVersion by extra("2.4.0-alpha03")
    val sqlDelightVersion by extra("1.5.0")
    repositories {
        google()
        mavenLocal()
        mavenCentral()
        maven("https://www.jetbrains.com/intellij-repository/releases")
        maven("https://jetbrains.bintray.com/intellij-third-party-dependencies")
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.0.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.21")
        classpath("com.apollographql.apollo3:apollo-gradle-plugin:$apolloVersion")
        classpath("com.squareup.sqldelight:gradle-plugin:$sqlDelightVersion")


        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.kts files
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
