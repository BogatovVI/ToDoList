package com.example.todo_list.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/todos", produces = "application/json")
public class ToDoController {

    @GetMapping
    public String HelloWorld(){
        return "Hello worlds";
    }
}
