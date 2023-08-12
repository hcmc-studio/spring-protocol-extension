val project_version: String by project
val jdk_version: String by project
val hcmc_extension_version: String by project
val spring_boot_version: String by project

plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    id("maven-publish")
}

group = "studio.hcmc"
version = project_version

repositories {
    mavenCentral()
    maven { setUrl("https://jitpack.io") }
}

kotlin {
    jvmToolchain(jdk_version.toInt())
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "studio.hcmc"
            artifactId = "spring-protocol-extension"
            version = project_version
            from(components["java"])
        }
    }
}

dependencies {
    implementation("com.github.hcmc-studio:kotlin-protocol-extension:$hcmc_extension_version")

    implementation("org.springframework.data:spring-data-commons:$spring_boot_version")
}