package org.acme;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.util.TypeLiteral;
import jakarta.inject.Inject;
import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.bind.Jsonb;
import org.acme.entity.Todo;

import java.io.StringReader;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@ApplicationScoped
public class JvmClient {
    private final ExecutorService executorService = Executors.newFixedThreadPool(5);

    private final HttpClient httpClient = HttpClient.newBuilder()
            .executor(executorService)
            .version(HttpClient.Version.HTTP_2)
            .build();


    @Inject
    Jsonb jsonb;

    CompletionStage<List<Todo>> getAllTodos() {

        // Have to erase the new line chars in the GraphQL schema to avoid the parsing exception.
        // see: https://github.com/quarkusio/quarkus/issues/17667
//        var queryString = """
//                {
//                  "query": "query {  todos {  id name description tasks { id  name description } } }"
//                }
//                """.replaceAll("\\n", " ");
        // The following forms are working well.
        var queryString = """
            {
               "query": "query {  todos {  id name description tasks { id  name description } } }"
            }
            """;
//
//        var queryString = "{\"query\": \"query { " +
//                "   todos { " +
//                "     id " +
//                "     name " +
//                "     description " +
//                "     tasks { " +
//                "       id " +
//                "       name " +
//                "       description "+
//                "     } " +
//                "   } " +
//                " }\"" +
//                "}";

        var request = HttpRequest.newBuilder()
                .POST(HttpRequest.BodyPublishers.ofString(queryString))
                .uri(URI.create("http://localhost:9091/graphql"))
                .header("Accept", "application/json")
                .header("Content-Type", "application/json")
                .build();
        HttpResponse.BodyHandler<String> handler = HttpResponse.BodyHandlers.ofString();
        return this.httpClient
                .sendAsync(request, handler)
                .thenApply(HttpResponse::body)
                .thenApply(this::extractTodos);

    }


    List<Todo> extractTodos(String s) {
        var reader = new StringReader(s);
        var json = Json.createReader(reader).read();
        var pointer = Json.createPointer("/data/todos");
        var jsonArray = (JsonArray) pointer.getValue(json);
        //@formatter:off
        return jsonb.fromJson(jsonArray.toString(), new TypeLiteral<List<Todo>>() {}.getRawType());
        //@formatter:on
    }
}