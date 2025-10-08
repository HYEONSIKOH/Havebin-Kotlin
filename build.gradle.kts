plugins {
    id("java")
    id("org.springframework.boot") version "3.5.6"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "com.project"
version = "0.0.1-SNAPSHOT"
description = "Have-bin project refactor"

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

repositories {
    mavenCentral()
}

dependencies {
    // Spring Boot Starter & Spring WebFlux
    implementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // Spring OAuth2 & Security
//    implementation("org.springframework.boot:spring-boot-starter-oauth2-client")
//    implementation("org.springframework.boot:spring-boot-starter-security")

    // MariaDB & Spring JPA
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    runtimeOnly("org.mariadb.jdbc:mariadb-java-client")

    // Redis
    // Lettuce는 비동기, Jedis는 동기 → Lettuce는 Jedis보다 성능이 좋아 권장
    implementation("org.springframework.boot:spring-boot-starter-data-redis")

    // Lombok
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")

    // Swagger
    // implementation("org.springdoc:springdoc-openapi-starter-webflux-ui:2.0.2")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.6.0")

    // Validation (@NotNull, @Size, @Min, @Max 등)
    implementation("org.springframework.boot:spring-boot-starter-validation")

    // JWT
    implementation("io.jsonwebtoken:jjwt-api:0.12.5")
    runtimeOnly("io.jsonwebtoken:jjwt-impl:0.12.5")
    runtimeOnly("io.jsonwebtoken:jjwt-jackson:0.12.5")

    // Mockito - Test 라이브러리
    implementation("org.mockito:mockito-junit-jupiter")

    // AWS S3
    implementation("io.awspring.cloud:spring-cloud-aws-starter-s3:3.1.0")
    implementation("software.amazon.awssdk:s3:2.29.14")

    // Spring Boot Mail Starter
    implementation("org.springframework.boot:spring-boot-starter-mail")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.bootJar {
    archiveFileName.set("havebin.jar")
}