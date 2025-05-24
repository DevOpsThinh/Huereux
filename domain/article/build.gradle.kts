plugins {
  alias(libs.plugins.kotlin.jvm)
}

apply("${rootProject.projectDir}/domain-libs.gradle")

dependencies {
  implementation(projects.domain.media)
}
