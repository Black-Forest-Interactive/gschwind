plugins {
    kotlin("jvm")
    kotlin("plugin.allopen")
    kotlin("plugin.serialization")
    id("com.google.devtools.ksp")
    jacoco
}

dependencies {
    // caching
    implementation("com.github.ben-manes.caffeine:caffeine:3.2.2")
}
