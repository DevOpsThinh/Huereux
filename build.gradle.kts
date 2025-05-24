// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.multiplatform) apply false
    alias(libs.plugins.android.kotlin.multiplatform.library) apply false
}

allprojects {
    group = "com.dev4ever.huereux"
    version = "1.0-SNAPSHOT"

//    repositories {
//        mavenCentral()
//    }
}

kotlin {
    jvmToolchain(21)
}



