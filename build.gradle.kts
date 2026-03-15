plugins {
	groovy
	java
	alias(libs.plugins.springBootVersion)
	alias(libs.plugins.springDependencyManagement)
}

group = "com.developbetter"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(25)
	}
}

repositories {
	mavenCentral()
}

extra["springAiVersion"] = "1.1.2"

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.ai:spring-ai-starter-model-openai")
	implementation("org.springframework.ai:spring-ai-starter-model-ollama")

	developmentOnly("org.springframework.boot:spring-boot-docker-compose")
	developmentOnly("org.springframework.ai:spring-ai-spring-boot-docker-compose")

	testImplementation(platform(libs.spock.bom))
	testImplementation(libs.bundles.spock.spring.integration.testing)
	testImplementation(platform(libs.testcontainers.bom)) {
		exclude(group = "org.apache.commons", module = "commons-compress")
	}
	testImplementation("org.testcontainers:testcontainers")
	testImplementation("org.testcontainers:testcontainers-spock")
	testImplementation("org.testcontainers:testcontainers-ollama")
	testImplementation(libs.commons.compress)
	testImplementation(libs.commons.lang3)
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.springframework.boot:spring-boot-testcontainers")
	testImplementation("org.springframework.ai:spring-ai-spring-boot-testcontainers")

	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

dependencyManagement {
	imports {
		mavenBom("org.springframework.ai:spring-ai-bom:${property("springAiVersion")}")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
