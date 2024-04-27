plugins {
    java
    id("org.springframework.boot") version "3.2.5"
    id("io.spring.dependency-management") version "1.1.4"
}

group = "sim"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
    mavenCentral()
}

dependencies {
//    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web:3.2.5")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    implementation("org.springframework.boot:spring-boot-starter-data-redis:3.2.5")
    developmentOnly("org.springframework.boot:spring-boot-docker-compose")

    implementation("redis.clients:jedis:5.1.2")


    implementation("org.modelmapper:modelmapper:3.2.0")
    compileOnly("org.projectlombok:lombok:1.18.32")



}

tasks.withType<Test> {
    useJUnitPlatform()
}
