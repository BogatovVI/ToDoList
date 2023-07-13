package com.example.todo_list.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AppError {
    private int statusCode;
    private String message;
}