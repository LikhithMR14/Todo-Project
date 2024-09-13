package com.ivoyant.springboot_todo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ivoyant.springboot_todo.annotations.PriorityAnnotationValidation;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.AssertFalse;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "description cannot be blank")
    private String description;

    @PriorityAnnotationValidation
    private String priority;

    @AssertFalse(message = "completed value should be false when todo is created")
    private boolean completed;

}

