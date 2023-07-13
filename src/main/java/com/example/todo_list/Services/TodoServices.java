package com.example.todo_list.Services;

import com.example.todo_list.Model.Todo;

import java.util.List;

public interface TodoServices {
    List<Todo> responseAllTodos();
    Todo createTodo(String name);
    Todo updateTodo(Long id, Todo todo);
    void deleteTodo(Long id);
}