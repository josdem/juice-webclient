Juice WebClient
----------------------------------------

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


#### Read this as reference:

* https://josdem.io/techtalk/spring/spring_boot_webclient/
* https://josdem.io/techtalk/spring/spring_webflux_client/