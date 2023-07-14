package com.example.todo_list.Model;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "Информация о задаче")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Schema(description = "Идентификатор задачи")
    private Long id;

    public Todo(@NotNull String name) {
        this.name = name;
    }

    @Schema(description = "Описание задачи")
    @NotNull
    @Size(min = 5)
    private String name;

    @Schema(description = "Дата создания задачи")
    private Date createdAt = new Date();
}