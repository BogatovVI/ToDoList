package com.example.todo_list.Controllers;

import com.example.todo_list.Model.Todo;
import com.example.todo_list.Services.TodoServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@RestController
@RequestMapping(path = "/api/todos", produces = "application/json")
@Tag(name = "Задачи", description = "Методы для работы с задачами")
public class ToDoController {

    private final TodoServices toDoServices;

    @GetMapping
    @Operation(summary = "Получить все задачи")
    public List<Todo> getAllTodo(){
        return toDoServices.responseAllTodos();
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Создать новую задачу")
    public Todo createTodo(@RequestBody Todo todo){
        return toDoServices.createTodo(todo.getName());
    }

    @PutMapping(path = "/{id}")
    @Operation(summary = "Обновить существующую задачу по id")
    public Todo updateTodo(
            @Parameter(description = "Уникальный идентификатор задачи") @PathVariable Long id,
            @RequestBody Todo todo){
        return toDoServices.updateTodo(id, todo);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    @Operation(summary = "Удалить задачу по id")
    public void deleteTodo(
            @Parameter(description = "Уникальный идентификатор задачи") @PathVariable Long id){
        toDoServices.deleteTodo(id);
    }
}