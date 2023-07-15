package org.acme.fetcher.mutation;


import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.acme.entity.Task;
import org.acme.entity.Todo;
import org.acme.input.TaskInput;
import org.acme.input.TodoInput;
import org.acme.repository.TaskRepository;
import org.acme.repository.TodoRepository;
import org.eclipse.microprofile.graphql.GraphQLApi;
import org.eclipse.microprofile.graphql.Mutation;
import org.eclipse.microprofile.graphql.Name;

import java.util.ArrayList;
import java.util.List;


/**
 * created by ronney
 */
@GraphQLApi
@RequiredArgsConstructor
public class TodoMutation {
    private final TodoRepository todoRepository;
    private final TaskRepository taskRepository;
    @Mutation("createTodo")
    @Transactional
    public Todo createTodo(@Name("todo") TodoInput todoInput, @Name("tasks") List<TaskInput> taskInputs) {
        Todo todoToSave = new Todo();
        todoToSave.setName(todoInput.getName());
        todoToSave.setDescription(todoInput.getDescription());

        List<Task> tasks = new ArrayList<>();
        if (taskInputs != null) {
            for (TaskInput taskInput : taskInputs) {
                Task task = new Task();
                task.setName(taskInput.getName());
                task.setDescription(taskInput.getDescription());
                task.setTodo(todoToSave);
                tasks.add(task);
            }
        }

        todoToSave.setTasks(tasks);
        todoRepository.persist(todoToSave);
        return todoToSave;

    }


    @Mutation("deleteTodo")
    @Transactional
    public boolean deleteTodo(
            @Name("id") Long id
    ) {
        Todo todoToDelete = todoRepository.findById(id);
        if (todoToDelete != null) {
            List<Task> tasksToDelete = todoToDelete.getTasks();
            for (Task task : tasksToDelete) {
                taskRepository.delete(task);
            }
            todoRepository.delete(todoToDelete);
            return true;
        }
        return false;
    }

    @Mutation("updateTodo")
    @Transactional
    public Todo updateTodo(
            @Name("id") Long id,
            @Name("todoUpdate") TodoInput updatedTodo,
            @Name("taskUpdates") List<TaskInput> updatedTasks
    ) {
        Todo todoToUpdate = todoRepository.findById(id);
        if (todoToUpdate != null) {
            todoToUpdate.setName(updatedTodo.getName());
            todoToUpdate.setDescription(updatedTodo.getDescription());

            List<Task> tasks = new ArrayList<>();
            if (updatedTasks != null) {
                for (TaskInput taskInput : updatedTasks) {
                    Task task = new Task();
                    task.setName(taskInput.getName());
                    task.setDescription(taskInput.getDescription());
                    task.setTodo(todoToUpdate);
                    tasks.add(task);
                }
            }

            todoToUpdate.setTasks(tasks);
            todoRepository.persist(todoToUpdate);
            return todoToUpdate;
        }
        return null;
    }
}
