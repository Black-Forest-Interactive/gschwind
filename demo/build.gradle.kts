plugins {
    id("org.jetbrains.kotlin.jvm")
    id("org.jetbrains.kotlin.plugin.allopen")
    kotlin("plugin.serialization")
    id("com.google.devtools.ksp")
    jacoco
}

dependencies {
    implementation(project(":core"))
}
