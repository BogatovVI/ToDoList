package com.example.todo_list.Services.Imlp;

import com.example.todo_list.Services.TodoServices;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ToDoServicesImpl implements TodoServices {
    @Override
    public List<String> responseAllTodos() {
        List<String> responseList = new ArrayList<>();
        responseList.add("Прочитать книгу");
        responseList.add("Убраться");
        responseList.add("Покоромить кошку");
        return responseList;
    }
}
