# Coding Challenge -Backend
## Create a Todo 
```
mutation CREATE {
  createTodo(
    todo: {
      name: "Evening Todo"
      description: "manage and organize evening tasks "
    }
    tasks: [
            {
        name: "Go to Rewe to buy Groceries "
        description: "Buying Groceries for dinner preparation"
      }
      {
        name: "Listen to music"
        description: "helps to reduce stress"
      }

    ]
  ) {
    id
    name
    description
    tasks {
      id
      name
      description
    }
  }
}
```

## Update a Todo
```
mutation {
  updateTodo(id: 4, todoUpdate: {
    name: "Night Todo",
    description: "manage and organize Night tasks"
  }
    taskUpdates: [
            {
        name: "Go to Rewe to buy Groceries "
        description: "Buying Groceries for dinner preparation"
      }
      {
        name: "Listen to music"
        description: "helps to reduce stress"
      }

    ]
  
  ) {
    id
    name
    description
    tasks {
      id
      name
      description
    }
  }
}

```
## Delete Todo
```
 mutation  {
   deleteTodo(id :3)
}
```

## Get Todo by Id
```
query{
  todo(id: 2) {
    name
    description
    id tasks {
      id
        name
        description
     }
   
  }
}
```

## Get all Todos
```
 query {
  todos{
    name,
    description,
    id 
    tasks {
     id
       name
       description
     }
  }
    }
```
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
![Screenshot 2023-07-15 at 5 03 16 PM](https://github.com/ismaeli34/Coding_Challenge/assets/17925504/710a1d54-a894-49cd-8357-b4319bbc218b)

![Screenshot 2023-07-15 at 5 05 53 PM](https://github.com/ismaeli34/Coding_Challenge/assets/17925504/8089fb96-ba5f-40cc-ac8e-b2efa02d3cbb)
![Screenshot 2023-07-15 at 5 07 21 PM](https://github.com/ismaeli34/Coding_Challenge/assets/17925504/6a176668-7bec-4992-b7d3-7faf25d37474)
![Screenshot 2023-07-15 at 5 08 03 PM](https://github.com/ismaeli34/Coding_Challenge/assets/17925504/28cbf205-8bf8-4b1c-bf2f-c511d726a767)
![Screenshot 2023-07-15 at 5 09 22 PM](https://github.com/ismaeli34/Coding_Challenge/assets/17925504/22891106-49a9-47bb-a171-642a841d6bde)
![Screenshot 2023-07-15 at 5 04 09 PM](https://github.com/ismaeli34/Coding_Challenge/assets/17925504/6317e05b-1102-48c0-af44-38e7f9fbafe9)


## USING SMALLRYE GRAPHQL CLIENT

![Screenshot 2023-07-16 at 8 27 42 PM](https://github.com/ismaeli34/Coding_Challenge/assets/17925504/d100b409-92f4-414d-a359-526f111caa47)




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
