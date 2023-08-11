plugins {
    kotlin("jvm") version "1.9.0"
    kotlin("plugin.spring") version "1.9.0"
    id("maven-publish")
}

group = "studio.hcmc"
version = "0.0.6"

repositories {
    mavenCentral()
    maven { setUrl("https://jitpack.io") }
}

kotlin {
    jvmToolchain(17)
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "studio.hcmc"
            artifactId = "spring-protocol-extension"
            version = "0.0.6"
            from(components["java"])
        }
    }
}

dependencies {
    implementation("com.github.hcmc-studio:kotlin-protocol-extension:0.0.4-release")

    implementation("org.springframework.data:spring-data-commons:3.1.2")
}