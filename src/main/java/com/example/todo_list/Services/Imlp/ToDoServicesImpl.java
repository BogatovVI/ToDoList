package com.example.todo_list.Services.Imlp;

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
}
