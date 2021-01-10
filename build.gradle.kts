import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.3.7.RELEASE"
	id("io.spring.dependency-management") version "1.0.10.RELEASE"
	id("com.bmuschko.docker-spring-boot-application") version "6.6.1"
	kotlin("jvm") version "1.3.72"
	kotlin("plugin.spring") version "1.3.72"
}

group = "uk.co.lewisjefferies"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

dependencies {
	implementation("com.google.zxing", "core", version = "3.4.1")
	implementation("com.google.zxing", "javase", version = "3.4.1")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
	}
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

docker {
	springBootApplication {
		baseImage.set("openjdk:16-jdk-alpine")
		ports.set(listOf(8080))
		jvmArgs.set(listOf("-Dspring.profiles.active=default", "-Xmx512m"))
	}
}