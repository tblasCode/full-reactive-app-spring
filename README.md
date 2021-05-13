# Reactive full app 🚀

Demo reactivo con spring.

## Compilación 📦

```
mvn clean package
```

## Ejecución 🔧

```
curl http://localhost:8080/polls
```

## Test in local 🔧

```
mvn clean package
docker build -t ms-full-reactive .
./mvnw spring-boot:build-image

docker run -p 80:80 ms-full-reactive
```

## Construido con 🛠️

* [Sprint boot](https://spring.io/projects/spring-boot) - aplicacion Spring
* [postgresql](https://www.postgresql.org/)
* [Flyway](https://flywaydb.org/)
* [archunit](https://www.archunit.org/)
* [spring-data-jdbc](https://spring.io/projects/spring-data-jdbc)
* [Maven](https://maven.apache.org/) - Manejador de dependencias

## Autores ✒️

* ** tblas code
