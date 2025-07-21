plugins {
    id("org.jetbrains.kotlin.jvm") version "2.2.0"
    id("com.google.devtools.ksp") version "2.2.0-2.0.2"
    id("org.jetbrains.kotlin.plugin.allopen") version "2.2.0"
    id("org.jetbrains.kotlin.plugin.jpa") version "2.2.0"
    kotlin("plugin.serialization") version "2.2.0"
    id("net.researchgate.release") version "3.1.0"
    id("maven-publish")
    id("jacoco")
}

repositories {
    maven("https://s01.oss.sonatype.org/content/repositories/snapshots/") {
        mavenContent { snapshotsOnly() }
    }
    mavenCentral()
    maven("https://maven.tryformation.com/releases") {
        content {
            includeGroup("com.jillesvangurp")
        }
    }
}

subprojects {

    apply(plugin = "kotlin")
    apply(plugin = "jacoco")

    repositories {
        mavenCentral()
    }
}

release {
    git {
        requireBranch.set("development")
    }
    pushReleaseVersionBranch.set("master")
}