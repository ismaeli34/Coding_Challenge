package org.acme.client;

import io.smallrye.graphql.client.typesafe.api.ErrorOr;
import io.smallrye.graphql.client.typesafe.api.GraphQLClientApi;
import org.acme.entity.Todo;
import org.eclipse.microprofile.graphql.Description;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;

import java.util.List;

@GraphQLClientApi
public interface TodoClient {
    @Query
    public List<Todo> getAllTodos();

    @Query
    @Description("Get a specific todo by providing an id")
    public ErrorOr<Todo> getTodoById(@Name("id") String id);


}
