package com.example.todo_list.Controllers;

import com.example.todo_list.Model.Todo;
import com.example.todo_list.Services.TodoServices;
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
public class ToDoController {

    private final TodoServices toDoServices;

    @GetMapping
    public List<Todo> getAllTodo(){
        return toDoServices.responseAllTodos();
    }

    @PostMapping(consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Todo createTodo(@RequestBody Todo todo){
        return toDoServices.createTodo(todo.getName());
    }

    @PutMapping(path = "/{id}")
    public Todo updateTodo(@PathVariable Long id, @RequestBody Todo todo){
        return toDoServices.updateTodo(id, todo);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void deleteTodo(@PathVariable Long id){
        toDoServices.deleteTodo(id);
    }
}