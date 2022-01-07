# norwegian-organization-number-validator
A simple validator for, validation a norwegian organization number

See [brreg organisasjonsnummer](https://www.brreg.no/om-oss/oppgavene-vare/alle-registrene-vare/om-enhetsregisteret/organisasjonsnummeret/)
for more info on how validation of a norwegian organization number is done


[![Build and test](https://github.com/MikAoJk/norwegian-organization-number-validator/actions/workflows/build-and-test.yml/badge.svg)](https://github.com/MikAoJk/norwegian-organization-number-validator/actions/workflows/build-and-test.yml)
[![Validate Gradle Wrapper](https://github.com/MikAoJk/norwegian-organization-number-validator/actions/workflows/gradle-wrapper-validation.yml/badge.svg)](https://github.com/MikAoJk/norwegian-organization-number-validator/actions/workflows/gradle-wrapper-validation.yml)
[![Build and publish artifact](https://github.com/MikAoJk/norwegian-organization-number-validator/actions/workflows/release.yml/badge.svg)](https://github.com/MikAoJk/norwegian-organization-number-validator/actions/workflows/release.yml)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/io.github.MikAoJk/norwegian-organization-number-validator/badge.svg)](https://maven-badges.herokuapp.com/maven-central/io.github.MikAoJk/norwegian-organization-number-validator/)


## Technologies used
* Kotlin
* Gradle
* JDK 11

#### Build and run tests
To build locally and run the integration tests you can simply run `./gradlew clean build` or on windows
`gradlew.bat clean build`

#### Manual publish
To publish you can simply run `./gradlew clean build` and then run `./gradlew publish`

#### Publish of artifact
Artifact publish is done by Github Actions, and publish to Maven Central and Github Packages
