import org.jetbrains.kotlin.gradle.dsl.JvmTarget

group = "io.github.mikaojk"
version = System.getenv("NEW_VERSION") ?: "1.0.0"

val junitJupiterVersion = "6.0.0"
val kotlinVersion = "2.2.21"
val ktfmtVersion = "0.44"

plugins {
    kotlin("jvm") version "2.2.21"
    id("com.github.ben-manes.versions") version "0.53.0"
    id("com.diffplug.spotless") version "8.0.0"
    id("com.vanniktech.maven.publish") version "0.34.0"
}

repositories {
    mavenCentral()
}

kotlin {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_21)
    }
}


dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion")

    testImplementation("org.junit.jupiter:junit-jupiter:$junitJupiterVersion")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

mavenPublishing {
    publishToMavenCentral(automaticRelease = true)
    signAllPublications()

    coordinates(group.toString(), "norwegian-organization-number-validator", version.toString())
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
