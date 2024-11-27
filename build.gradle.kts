import org.jetbrains.kotlin.gradle.dsl.JvmTarget

group = "io.github.mikaojk"
version = "1.0.0"

val junitJupiterVersion = "5.11.3"
val kotlinVersion = "2.0.21"
val ktfmtVersion = "0.44"
val javaVersion = JavaVersion.VERSION_21

plugins {
    kotlin("jvm") version "2.1.0"
    id("com.github.ben-manes.versions") version "0.51.0"
    id("com.diffplug.spotless") version "6.25.0"
    `maven-publish`
    signing
}

repositories {
    mavenCentral()
}

kotlin {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_21)
    }
}

publishing {
    repositories {
        maven {
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/MikAoJk/norwegian-organization-number-validator")
            credentials {
                username = System.getenv("GITHUB_USERNAME")
                password = System.getenv("GITHUB_PASSWORD")
            }
        }
    }
    publications {
        create<MavenPublication>("mavenJava") {
            pom {
                name.set("norwegian-organization-number-validator")
                description.set("Library for validation a norwegian organization number")
                url.set("https://github.com/MikAoJk/norwegian-organization-number-validator")
                inceptionYear.set("2024")
                licenses {
                    license {
                        name.set("MIT License")
                        url.set("https://opensource.org/licenses/MIT")
                    }
                }
                developers {
                    developer {
                        id.set("MikAoJk")
                        name.set("Joakim Taule Kartveit")
                        email.set("joakimkartveit@gmail.com")
                    }
                }

                scm {
                    connection.set("scm:git:https://github.com/MikAoJk/norwegian-organization-number-validator.git")
                    developerConnection.set("scm:git:https://github.com/MikAoJk/norwegian-organization-number-validator.git")
                    url.set("https://github.com/MikAoJk/norwegian-organization-number-validator")
                }
                version = System.getenv("NEW_VERSION")
            }
            from(components["java"])
        }
    }
}

signing {
    val signingKey: String? by project
    val signingPassword: String? by project
    useInMemoryPgpKeys(signingKey, signingPassword)
    sign(publishing.publications["mavenJava"])
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")

    testImplementation("org.junit.jupiter:junit-jupiter:$junitJupiterVersion")
}

tasks {

    spotless {
        kotlin { ktfmt(ktfmtVersion).kotlinlangStyle() }
        check {
            dependsOn("spotlessApply")
        }
    }

    javadoc {
        (options as StandardJavadocDocletOptions).addBooleanOption("html5", true)
    }

    test {
        useJUnitPlatform()
        testLogging {
            events("skipped", "failed")
            showStackTraces = true
            showExceptions = true
            showCauses = true
            exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
        }
    }
}
