plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.20.1")
    annotationProcessor ("org.projectlombok:lombok:1.18.42")
    implementation("com.fasterxml.jackson.core:jackson-annotations:2.20")
    implementation("org.projectlombok:lombok:1.18.42")
//    implementation("tools.jackson.core:jackson-databind:3.0.3")
    implementation("org.apache.httpcomponents.client5:httpclient5:5.5.1")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.20.1")
    implementation("com.fasterxml.jackson.core:jackson-core:2.20.1")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.test {
    useJUnitPlatform()
}