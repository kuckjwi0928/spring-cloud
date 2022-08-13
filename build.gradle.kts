import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id("org.springframework.boot") version "2.7.2" apply false
  id("io.spring.dependency-management") version "1.0.12.RELEASE"
  id("com.google.cloud.tools.jib") version "3.2.1" apply false
  kotlin("jvm") version "1.6.21" apply false
  kotlin("plugin.spring") version "1.6.21" apply false
}

allprojects {
  group = "com.kuckjwi.spring.cloud"
  version = "0.0.1"

  tasks.withType<JavaCompile> {
    sourceCompatibility = "11"
    targetCompatibility = "11"
  }

  tasks.withType<KotlinCompile> {
    kotlinOptions {
      freeCompilerArgs = listOf("-Xjsr305=strict")
      jvmTarget = "11"
    }
  }

  tasks.withType<Test> {
    useJUnitPlatform()
  }
}

extra["springCloudVersion"] = "2021.0.3"

subprojects {
  apply {
    plugin("org.springframework.boot")
    plugin("io.spring.dependency-management")
    plugin("kotlin")
    plugin("com.google.cloud.tools.jib")
  }

  repositories {
    mavenCentral()
  }

  val implementation by configurations
  val testImplementation by configurations

  dependencyManagement {
    imports {
      mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
  }

  dependencies {
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("org.springframework.cloud:spring-cloud-starter-sleuth")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
  }
}
