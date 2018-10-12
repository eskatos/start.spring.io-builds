import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.2.51"
    id("org.jetbrains.kotlin.plugin.spring") version "1.2.51"
    id("org.springframework.boot") version "2.0.5.RELEASE"
    id("io.spring.dependency-management") version "1.0.6.RELEASE"
    eclipse
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "1.8"
    }
}

repositories {
    mavenCentral()
}

// Move to buildSrc/src/main/groovy to reference it from sub project build scripts
object DependencyVersions {
    val springCloudVersion = "Finchley.SR1"
}

dependencies {
    implementation("org.springframework.cloud:spring-cloud-starter-config")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation(enforcedPlatform("org.springframework.cloud:spring-cloud-dependencies:${DependencyVersions.springCloudVersion}"))
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

