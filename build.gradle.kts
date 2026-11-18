plugins {
    kotlin("jvm") version "2.1.0"
}

group = "lab"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2")
}