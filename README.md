# norwegian-organization-number-validator
A simple validator for, validation a norwegian organization number

See [brreg organisasjonsnummer](https://www.brreg.no/om-oss/oppgavene-vare/alle-registrene-vare/om-enhetsregisteret/organisasjonsnummeret/)
for more info on how validation of a norwegian organization number is done

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
