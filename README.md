Juice WebClient
----------------------------------------

[![Build Status](https://app.travis-ci.com/josdem/juice-webclient.svg?branch=master)](https://app.travis-ci.com/josdem/juice-webclient)
[![Quality Gate Status](https://sonar.josdem.io/api/project_badges/measure?project=com.josdem.jugoterapia.webclient%3Ajuice-webclient&metric=alert_status)](https://sonar.josdem.io/dashboard?id=com.josdem.jugoterapia.webclient%3Ajuice-webclient)

This project shows how to test an API as library using [WebClient](https://docs.spring.io/spring-boot/docs/2.0.3.RELEASE/reference/html/boot-features-webclient.html) with [Junit Jupiter](https://junit.org/junit5/docs/current/user-guide/)

#### To test the project with Gradle

```bash
gradle test
```

#### To test the project with Maven

```bash
mvn test
```

### To run a single test with Gradle

```bash
gradle test --tests ${testName}
```

### To run a single test with Maven

```bash
mvn test -Dtest=${testName}
```

where:

- `${testName}` is the test name you want to execute

### To publish library to artifactory using Gradle

```bash
export ARTIFACTORY_USER=${username}
export ARTIFACTORY_PASSWORD=${password}
gradle publish
```

where:

- `${username}` Is artifactory username
- `${password}` Is artifactory password

#### To run tests with Jacoco and Sonarqube

```bash
gradle jacocoTestReport sonarqube test
```

### To publish library to artifactory using Maven

```bash
mvn deploy
```

Make sure you setup your artifactory credentials in `${USER_HOME}/.m2/settings.xml`

```xml
<settings>
  <servers>
    <server>
      <id>artifactory</id>
      <username>username</username>
      <password>password</password>
    </server>
  </servers>
</settings>
```

**Note:** If you want to learn more and publish your own library, feel free to drop me a message on my home page website and ask for a Jfrog credentials.

#### For more information

Visit our wiki page: [Wiki page](https://github.com/josdem/juice-webclient/wiki)

#### Read this as reference:

* https://josdem.io/techtalk/spring/spring_boot_webclient/
* https://josdem.io/techtalk/spring/spring_webflux_client/
* https://josdem.io/techtalk/spring/spring_webflux_artifactory_library/