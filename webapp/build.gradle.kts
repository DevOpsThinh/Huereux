plugins {
  alias(libs.plugins.kotlin.jvm)
}

dependencies {
  implementation(projects.infrastructure.http)
}

kotlin {
  jvmToolchain(21)
}