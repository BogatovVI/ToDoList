package com.example.todo_list.Services.Imlp;

import com.example.todo_list.Exception.ResourceNotFoundException;
import com.example.todo_list.Model.Todo;
import com.example.todo_list.Repository.TodoRepository;
import com.example.todo_list.Services.TodoServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor
public class ToDoServicesImpl implements TodoServices {

    private final TodoRepository todoRepository;

    @Override
    public List<Todo> responseAllTodos() {
        return StreamSupport.stream(todoRepository.findAll().spliterator(), false).toList();
    }

    @Override
    public Todo createTodo(String name) {
        Todo todo = new Todo(name);
        return todoRepository.save(todo);
    }

    @Override
    public Todo updateTodo(Long id, Todo todo) {
        Todo todoOld = todoRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Todo with id " + id + " not found"));
        todoOld.setName(todo.getName());
        todoOld.setCreatedAt(todo.getCreatedAt());
        return todoRepository.save(todoOld);
    }

    @Override
    public void deleteTodo(Long id) {
        todoRepository.deleteById(id);
    }
}