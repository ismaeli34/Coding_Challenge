package org.acme;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import org.acme.entity.Todo;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

@ApplicationScoped
public class JaxrsClient {
    private static final Logger LOGGER = Logger.getLogger(JaxrsClient.class.getName());
    private final ExecutorService executorService = Executors.newCachedThreadPool();
    private final Client client;
    private final String baseUrl = "http://localhost:9091/graphql";

    public JaxrsClient() {
        client = ClientBuilder.newBuilder()
                .executorService(executorService)
                .build();
    }

    CompletionStage<List<Todo>> getAllTodos() {
        var queryString = """
                {
                  "query": "query {  todos {  id name description tasks { id  name description } } }"
                }
                """;

        return client.target(baseUrl)
                .request().accept(MediaType.APPLICATION_JSON_TYPE)
                .rx()
                //@formatter:off
                .post(Entity.entity(queryString, MediaType.APPLICATION_JSON_TYPE),
                        new GenericType<Map<String, Map<String, List<Todo>>>>(){})
                //@formatter:on
                .thenApply(r -> {
                    var data = r.get("data");
                    var todos = data.get("todos");
//                    System.out.println("---"+todos.toString());

                    return todos;
                });

    }

}
