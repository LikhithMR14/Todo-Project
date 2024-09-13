package com.ivoyant.springboot_todo.annotations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.List;

public class PriorityAnnotationValidator implements ConstraintValidator<PriorityAnnotationValidation,String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        List<String> list=List.of("HIGH","LOW");
        return list.contains(s);
    }
}
