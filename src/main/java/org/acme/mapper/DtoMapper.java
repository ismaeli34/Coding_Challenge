package org.acme.mapper;
import org.acme.dto.TodoDto;
import org.acme.entity.Todo;

public class DtoMapper {

    public static TodoDto toTodoDto(Todo todo){

        TodoDto todoDto = new TodoDto();
        todoDto.setId(todo.getId());
        todoDto.setName(todo.getName());
        todoDto.setDescription(todo.getDescription());
        return todoDto;
    }








}


