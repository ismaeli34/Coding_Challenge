package org.acme.client;

import io.smallrye.graphql.client.GraphQLClient;
import io.smallrye.graphql.client.Response;
import io.smallrye.graphql.client.core.Document;
import io.smallrye.graphql.client.dynamic.api.DynamicGraphQLClient;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.acme.dto.TodoDto;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static io.smallrye.graphql.client.core.Document.document;
import static io.smallrye.graphql.client.core.Field.field;
import static io.smallrye.graphql.client.core.Operation.operation;

@ApplicationScoped
public class TodoDynamicClient {

    @Inject
    @GraphQLClient("post-dynamic-client")
    DynamicGraphQLClient dynamicClient;

    public List<TodoDto> getAllTodos() throws ExecutionException, InterruptedException {
        Document query = document(
                operation(
                        field("todos",
                                field("id"),
                                field("name"),
                                field("description"),
                                field("tasks",
                                        field("id"),
                                        field("name"),
                                        field("description")


                                )
                        )
                )
        );
        Response response = dynamicClient.executeSync(query);
        return response.getList(TodoDto.class, "todos");
    }
}
