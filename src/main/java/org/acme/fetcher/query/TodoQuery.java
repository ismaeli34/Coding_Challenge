package org.acme.fetcher.query;


import lombok.RequiredArgsConstructor;
import org.acme.entity.Todo;
import org.acme.repository.TodoRepository;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;

import java.util.List;
import java.util.stream.Collectors;

/**
 * created by ronney
 */
@GraphQLApi
@RequiredArgsConstructor
public class TodoQuery {
    private final TodoRepository repository;
    // to get all todos
    @Query("todos")
    public List<Todo> findAll() {
        return repository.findAll().stream().collect(Collectors.toList());
    }
    @Query("todo")
    public Todo findById(@Name("id") Long id) {
        return repository.findById(id);
    }



}
