// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.kotlin.jvm)
}

allprojects {
    group = "com.dev4ever"
    version = "1.0-SNAPSHOT"

    repositories {
        mavenCentral()
    }
}

kotlin {
    jvmToolchain(21)
}



