plugins {
    kotlin("jvm")
    kotlin("plugin.allopen")
    kotlin("plugin.serialization")
    id("com.google.devtools.ksp")
    jacoco
}

dependencies {
    implementation(project(":core"))

    api("org.apache.kafka:kafka-clients:4.1.0")
}
