package com.example.todo_list.Repository;

import com.example.todo_list.Model.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {
}