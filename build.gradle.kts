// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.kotlin.jvm)
}

group = "com.dev4ever"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<Test>().configureEach {
    maxParallelForks = (Runtime.getRuntime().availableProcessors() / 2)
        .coerceAtLeast(1)
}

tasks.withType<JavaCompile>().configureEach {
    options.isFork = true
}

kotlin {
    jvmToolchain(21)
}