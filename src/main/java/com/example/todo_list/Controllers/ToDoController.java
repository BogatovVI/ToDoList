package com.example.todo_list.Controllers;

import com.example.todo_list.Model.Todo;
import com.example.todo_list.Services.TodoServices;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@RestController
@RequestMapping(path = "/api/todos", produces = "application/json")
public class ToDoController {

    private final TodoServices toDoServices;

    @GetMapping
    public List<Todo> GetAllTodo(){
        return toDoServices.responseAllTodos();
    }
}
