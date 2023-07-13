package com.example.todo_list.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Date;

@Data
@Entity
@NoArgsConstructor
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Todo(@NotNull String name) {
        this.name = name;
    }

    @NotNull
    @Size(min = 5)
    private String name;

    private Date createdAt = new Date();
}