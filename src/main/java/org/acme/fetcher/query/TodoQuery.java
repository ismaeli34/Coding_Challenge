package org.acme.fetcher.query;


import jakarta.inject.Inject;
import lombok.RequiredArgsConstructor;
import org.acme.dto.TodoDto;
import org.acme.entity.Todo;
import org.acme.repository.TodoRepository;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Name;
import org.eclipse.microprofile.graphql.Query;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

/**
 * created by ronney
 */
@GraphQLApi
@RequiredArgsConstructor
public class TodoQuery {
    private final TodoRepository repository;

    @Inject
    ModelMapper modelMapper;
    // to get all todos
    @Query("todos")
    public List<TodoDto> findAll() {

        List<TodoDto> collect = repository.findAll().stream().map((todo) -> this.modelMapper.map(todo, TodoDto.class))
                .collect(Collectors.toList());
        return collect;

    }
    @Query("todo")
    public TodoDto findById(@Name("id") Long id) {
        Todo todoById = repository.findById(id);
        TodoDto todoDto = this.modelMapper.map(todoById, TodoDto.class);
        return todoDto;
    }



}
