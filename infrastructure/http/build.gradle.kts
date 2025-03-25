plugins {
  alias(libs.plugins.kotlin.jvm)
}

apply("${rootProject.projectDir}/infras-testing-libs.gradle")

dependencies {
  implementation(libs.http4k.core)
  implementation(libs.http4k.server.jetty)

  testImplementation(libs.http4k.client.jetty)
}
