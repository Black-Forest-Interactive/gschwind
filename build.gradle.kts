import org.jetbrains.kotlin.gradle.dsl.JvmTarget

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

    dependencies {
        implementation("ch.qos.logback:logback-classic:1.5.18")

        testImplementation("org.junit.jupiter:junit-jupiter-api:5.13.4")
        testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.13.4")
        testImplementation("io.mockk:mockk:1.14.5")

        // jackson
        implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.19.2")
        implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.19.2")

        // kotlin
        implementation("org.jetbrains.kotlin:kotlin-reflect:2.2.0")
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:2.2.0")

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