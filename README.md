# code-with-quarkus-todoapp

## Application.properties
```application.properties
quarkus.http.port=9090
quarkus.swagger-ui.enable=true
quarkus.datasource.db-kind=mysql
quarkus.datasource.username=root
quarkus.datasource.password=password
quarkus.datasource.jdbc.url=jdbc:mysql://localhost:3306/TodoDB?serverTimezone=UTC
quarkus.hibernate-orm.log.sql=true
quarkus.hibernate-orm.database.generation=create
spring.graphql.graphiql.enabled=true



```

# Screenshots
![Screenshot 2023-07-15 at 5 03 16 PM](https://github.com/ismaeli34/Coding_Challenge/assets/17925504/2d7e69df-8ce5-41d9-8deb-b2e0b854f44e)

![Screenshot 2023-07-15 at 5 05 53 PM](https://github.com/ismaeli34/Coding_Challenge/assets/17925504/b576d601-6ad2-4743-8a40-966c597fb062)

![Screenshot 2023-07-15 at 5 07 21 PM](https://github.com/ismaeli34/Coding_Challenge/assets/17925504/04ce1afa-5a1d-4aa1-83f1-c1cb30214a85)

![Screenshot 2023-07-15 at 5 08 03 PM](https://github.com/ismaeli34/Coding_Challenge/assets/17925504/96f7c309-a922-4290-8ccc-f59e706b6df7)

![Screenshot 2023-07-15 at 5 09 22 PM](https://github.com/ismaeli34/Coding_Challenge/assets/17925504/84d2fe3f-ca9b-454c-8ac0-ca8050d9b712)

![Screenshot 2023-07-15 at 5 04 09 PM](https://github.com/ismaeli34/Coding_Challenge/assets/17925504/66dcaef1-2876-4343-abcb-df2d536f3b9d)



This project uses Quarkus, the Supersonic Subatomic Java Framework.

If you want to learn more about Quarkus, please visit its website: https://quarkus.io/ .

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Packaging and running the application

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

## Creating a native executable

You can create a native executable using: 
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/code-with-quarkus-todoapp-1.0.0-SNAPSHOT-runner`

If you want to learn more about building native executables, please consult https://quarkus.io/guides/maven-tooling.

## Related Guides

- SmallRye OpenAPI ([guide](https://quarkus.io/guides/openapi-swaggerui)): Document your REST APIs with OpenAPI - comes with Swagger UI
- RESTEasy Reactive ([guide](https://quarkus.io/guides/resteasy-reactive)): A Jakarta REST implementation utilizing build time processing and Vert.x. This extension is not compatible with the quarkus-resteasy extension, or any of the extensions that depend on it.
- Hibernate ORM with Panache ([guide](https://quarkus.io/guides/hibernate-orm-panache)): Simplify your persistence code for Hibernate ORM via the active record or the repository pattern
- RESTEasy Classic ([guide](https://quarkus.io/guides/resteasy)): REST endpoint framework implementing Jakarta REST and more
- JDBC Driver - MySQL ([guide](https://quarkus.io/guides/datasource)): Connect to the MySQL database via JDBC
- SmallRye GraphQL ([guide](https://quarkus.io/guides/smallrye-graphql)): Create GraphQL Endpoints using the code-first approach from MicroProfile GraphQL

## Provided Code

### Hibernate ORM

Create your first JPA entity

[Related guide section...](https://quarkus.io/guides/hibernate-orm)

[Related Hibernate with Panache section...](https://quarkus.io/guides/hibernate-orm-panache)


### RESTEasy JAX-RS

Easily start your RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started#the-jax-rs-resources)

### RESTEasy Reactive

Easily start your Reactive RESTful Web Services

[Related guide section...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)

### SmallRye GraphQL

Start coding with this Hello GraphQL Query

[Related guide section...](https://quarkus.io/guides/smallrye-graphql)
# Graphql_Quarkus_assignment
# Technical_assignment
# Coding_Challenge
