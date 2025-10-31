import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    kotlin("jvm") version "2.2.20"
    kotlin("plugin.allopen") version "2.2.20"
    kotlin("plugin.serialization") version "2.2.20"
    id("com.google.devtools.ksp") version "2.2.20-2.0.4"
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

    dependencies {
        implementation("ch.qos.logback:logback-classic:1.5.19")

        testImplementation("org.junit.jupiter:junit-jupiter-api:6.0.0")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:6.0.0")
        testImplementation("io.mockk:mockk:1.14.6")

        // jackson
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.20.0")
        implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.20.1")

        // kotlin
        implementation("org.jetbrains.kotlin:kotlin-reflect:2.2.20")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:2.2.20")

        // coroutines
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactive:1.10.2")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:1.10.2")

        // test
        testImplementation("org.testcontainers:junit-jupiter:1.21.3")
    }


    java {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }

    tasks {
        compileKotlin {
            compilerOptions {
                jvmTarget.set(JvmTarget.JVM_21)
            }
        }

        compileTestKotlin {
            compilerOptions {
                jvmTarget.set(JvmTarget.JVM_21)
            }
        }
    }



    tasks.test {
        useJUnitPlatform()
        finalizedBy(tasks.jacocoTestReport)
    }
    tasks.jacocoTestReport {
        dependsOn(tasks.test)
        reports {
            xml.required.set(true)
            csv.required.set(false)
        }
    }
    jacoco {
        toolVersion = "0.8.13"
    }

}

release {
    git {
        requireBranch.set("development")
    }
    pushReleaseVersionBranch.set("master")
}